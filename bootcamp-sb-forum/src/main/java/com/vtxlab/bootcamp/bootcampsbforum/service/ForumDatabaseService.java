package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;

// import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

public interface ForumDatabaseService {
    
    List<User> saveUsers(List<User> users);

    void deleteAllUsers();

    User saveUser(User users);
}
