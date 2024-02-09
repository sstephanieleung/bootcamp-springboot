package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@ResponseBody
@RequestMapping(value = "/api/v1")

public class UserController implements UserOperation {
    
    @Autowired
    private UserService userService;


    @Override
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
