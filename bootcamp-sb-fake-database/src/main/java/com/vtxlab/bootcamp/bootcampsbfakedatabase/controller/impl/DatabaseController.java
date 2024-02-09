package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// import com.vtxlab.bootcamp.bootcampsbfakedatabase.BootcampSbFakeDatabaseApplication;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
// import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;
// import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl.CatDatabaseServiceImpl;


// @Controller
//@ResponseBody  //return JSON format
@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

    @Autowired // dependency injection 自動裝配
    private CatDatabaseService catDatabaseService;

    @Override
    public Cat getCat(int index) {
        // return new CatDatabaseServiceImpl().getFromStaticMemory(index);
        return catDatabaseService.getCat(index);
    }

    // Just practice, Normally we use PostMapping
    @Override
    public Cat setCat(int index, String name, int age) {
        // new CatDatabaseServiceImpl().setFromStaticMemory(index, new Cat(name, age));
        catDatabaseService.setCat(index, new Cat(name, age));
        return catDatabaseService.getCat(index);
    }

    @Override
    public Cat createCat(int idx, Cat cat) {
        return catDatabaseService.setCat(idx, cat);
    }

    @Override
    public Boolean deleteCat(int idx){
        return catDatabaseService.removeCat(idx) != null;
    }

    @Override
    public Cat updateCat(int idx, Cat cat){
        return catDatabaseService.updateCat(idx, cat);
    }

    @Override
    public Cat patchCatName(int idx, String name){
        return catDatabaseService.updateCatName(idx, name);
    }

    @Override
    public Cat patchCatAge(int idx, int age){
        return catDatabaseService.updateCatAge(idx, age);
    }

    @Override
    public List<Cat> getCats() {
        return Arrays.stream(catDatabaseService.getAllCat()).collect(Collectors.toList());
    }

    @Override
    public Cat getCat2(int idx) {
        return catDatabaseService.getCat(idx);
    }
}
