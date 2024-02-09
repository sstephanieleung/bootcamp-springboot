package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class) // Inject the web layer related bean to context only
// In this test environement, ComponentScan will ignore @Service,
// @Configuration, etc.
// But include @Controller bean, mockmvc beans etc.
class DatabaseControllerTests {

        @Autowired
        private MockMvc mockMvc;

        // @Autowired //Cannot @Autowired because component scan ignore the service
        // object
        @MockBean // Assuming the context has this object
        // Because Controller Bean need to autowired catDatabaseService
        private CatDatabaseService catDatabaseService;

        @Test
        void testGetCat() throws Exception {
                // "http://127.0.0.1:8080/api/v1/x/{x}/y/{y}"

                // assumption
                Cat mockedReturnCat = new Cat("ABC", 3);

                // when
                Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnCat);

                // assert
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}", "1"))
                                .andExpect(status().isOk()) // http code 200 - OK
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.name").value("ABC"))
                                .andExpect(jsonPath("$.age").value(3))
                                .andDo(print()); // similar to sysout, toString()

                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat2/{idx}", "1"))
                                .andExpect(status().isNotFound()) // http code 404 - Not Found
                                .andDo(print()); // similar to sysout, toString()

        }

        @Test
        void testException() throws Exception {
                Cat mockedReturnCat = new Cat("ABC", 3);
                Mockito.when(catDatabaseService.getCat(11)).thenThrow(new RuntimeException());

                // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}", "11"))
                // .andExpect(status().isInternalServerError()) // http code 500 - Internal
                // Server Error
                // .andDo(print()); // similar to sysout, toString()
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}", 11))//
                                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
        }

        @Test
        void testPostCat() throws Exception {

                // assumption
                Cat mockedReturnCat = new Cat("ABC", 3);
                String contentString = new ObjectMapper().writeValueAsString(mockedReturnCat);

                // when
                Mockito.when(catDatabaseService.setCat(1, new Cat("John", 2))).thenReturn(mockedReturnCat);

                // assert
                mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/cat/{idx}", "1")
                                .contentType(MediaType.APPLICATION_JSON)
                                // .content("{\"name\": \"John\", \"age\": 2}"))
                                .content(contentString))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.name").value("ABC"))
                                .andExpect(jsonPath("$.age").value(3))
                                .andDo(print()); // similar to sysout, toString()

        }

        @Test
        void testDeleteCat() throws Exception {
                // assumption
                Cat mockedReturnCat = new Cat("ABC", 3);

                // when
                Mockito.when(catDatabaseService.removeCat(1)).thenReturn(mockedReturnCat);

                mockMvc.perform(delete("/api/v1/cat/{idx}", 1))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(content().string("true"));
                // .andExpect(jsonPath("$").value(true));

                mockMvc.perform(delete("/api/v1/cat/{idx}", 1))
                                .andExpect(status().isOk())
                                .andExpect(content().string("true"));
        }
}
