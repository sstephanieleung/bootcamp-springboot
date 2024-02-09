package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.BootcampSbFakeDatabaseApplication;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.SpringContextOperation;

@RestController
@RequestMapping(value = "/api/v1")
public class SpringContextController implements SpringContextOperation {

    @Autowired // find thing from Bean (Spring Context)
    @Qualifier(value = "tutor2")
    private CharSequence name;

    @Override
    public String getBean(int index) {
        return BootcampSbFakeDatabaseApplication.getSprinContext().getBeanDefinitionNames()[index];
    }

    @Override
    public String[] getAllBean() {
        return BootcampSbFakeDatabaseApplication.getSprinContext().getBeanDefinitionNames();
    }

    @GetMapping(value = "/tutorname")
    public CharSequence getTutorName() {
        return name;
    }
}
