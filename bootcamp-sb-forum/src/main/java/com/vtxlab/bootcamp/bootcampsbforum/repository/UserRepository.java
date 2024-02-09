package com.vtxlab.bootcamp.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository //Bean
public interface UserRepository extends JpaRepository<User, Long>{
    
    //Hibernate - When Spring Boot Run, it auto-gen a bean that implement this interface into Spring Content, no need to write by yourself
    //Objective: Implement JPA interface
}
