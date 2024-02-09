package com.vtxlab.bootcamp.bootcampsbhelloworld.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.bootcamp.bootcampsbhelloworld.model.Cat;

@Controller // Web lyaer, provide the capability of API
@ResponseBody //Return JSON (format of data transmission - System A call system B API)
@RequestMapping(value = "/api/v1")  //Base path of URI: version 1
public class HelloworldController {
    
    //Java: Attribute, constructor, instance methods

    //SpringBoot: No attributes, constructor
    //Have Instance method

    @GetMapping(value = "/hello")  // endpoint
    public String helloworld(){
        return "Welcome to Spring Boot.";
    }

    @GetMapping(value = "/primitive")
    public int ten(){
        return 10;
    }

    @GetMapping(value = "/object")
    public Cat cat(){
        return new Cat("John",2);
    }

    @GetMapping(value = "list")
    public List<Cat> list(){
        return Stream.of(new Cat(), new Cat("John",2)).collect(Collectors.toList());
    }

    @GetMapping(value = "/array")
    public Cat[] array(){
        return new Cat[]{new Cat(), new Cat("John",2)};
    }

    @GetMapping(value = "/wrapper")
    public Character wrapper(){
        // return Double.valueOf(3.2d);
        return Character.valueOf('c');
    }

    @GetMapping(value = "/streamArray")
    public Stream<Integer> streamArray(){
        Integer[] arr = new Integer[]{1,2};
        return Stream.of(arr);
    }
}