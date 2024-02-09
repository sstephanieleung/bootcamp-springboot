package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bootcampsbforum.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

    @Autowired
    private CommentService commentService;
    
    @Override
    public List<Comment> getComments(){
        return commentService.getComments();
    }
}
