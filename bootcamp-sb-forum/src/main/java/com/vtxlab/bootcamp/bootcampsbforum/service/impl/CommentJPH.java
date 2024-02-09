package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.bootcampsbforum.infra.GenURL;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@Service
public class CommentJPH implements CommentService {

    @Value(value = "${api.jph.domain}")
    private String domain;

    @Value(value = "${api.jph.endpoints.comment}")
    private String commentEndPoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Comment> getComments() {

        // RestTemplate restTemplate = new RestTemplate();
        String commentUrl = GenURL.url(Scheme.HTTP, domain, commentEndPoint);
        Comment[] comments = restTemplate.getForObject(commentUrl, Comment[].class);
        return Arrays.stream(comments)
                .collect(Collectors.toList());
    }
}
