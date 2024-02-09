package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {
    
    //
    Cat getCat(int index);

    Cat setCat(int index, Cat cat);

    Cat removeCat(int idx);

    Cat updateCat(int idx, Cat cat);

    Cat updateCatName(int idx, String name);

    Cat updateCatAge(int idx, int age);

    Cat[] getAllCat();

}
 