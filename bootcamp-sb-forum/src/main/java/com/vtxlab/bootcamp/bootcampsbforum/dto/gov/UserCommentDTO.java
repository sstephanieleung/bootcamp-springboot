package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDTO {

    private int id;
    
    private String username;

    private String email;

    private String phone;

    @JsonProperty(value = "comments")
    private List<Comment> commentDTOs;
}
