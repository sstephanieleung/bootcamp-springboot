package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;

public interface CommentOperation {
    
    @GetMapping(value = "/comments/get")
    List<Comment> getComments();
}
