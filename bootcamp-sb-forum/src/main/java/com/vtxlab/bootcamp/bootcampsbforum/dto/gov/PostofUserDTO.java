package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostofUserDTO {
    
    private int id;

    private String title;

    private String body;
}
