package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface SpringContextOperation {
    
    @GetMapping(value = "/bean/{bean}")
    String getBean(@PathVariable (name = "bean") int index);

    @GetMapping(value = "/beans")
    String[] getAllBean();
}
