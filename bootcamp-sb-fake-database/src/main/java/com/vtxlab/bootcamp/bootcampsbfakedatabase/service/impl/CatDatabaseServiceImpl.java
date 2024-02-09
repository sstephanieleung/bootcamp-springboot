package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
// @Component
public class CatDatabaseServiceImpl implements CatDatabaseService {
    // Objective of Service
    // 1, Data source
    // 2, The service you are going to provide
    // Controller call service
    // Service layer call either database or API

    @Override
    public Cat getCat(int index) {
        return CatDatabase.getCat(index);
    }

    @Override
    public Cat setCat(int index, Cat cat) {
        return CatDatabase.setCat(index, cat);
    }

    @Override
    public Cat removeCat(int idx) {
        Cat deleted = CatDatabase.getCat(idx);
        setCat(idx, null);
        return deleted;
    }

    @Override
    public Cat updateCat(int idx, Cat cat) {
        if (getCat(idx) == null)
            return null;
        return CatDatabase.setCat(idx, cat);
    }

    @Override
    public Cat updateCatName(int idx, String name) {
        if (getCat(idx) == null)
            return null;
        return CatDatabase.setCatName(idx, name);
    }

    @Override
    public Cat updateCatAge(int idx, int age) {
        if (getCat(idx) == null)
            return null;
        return CatDatabase.setCatAge(idx, age);
    }

    @Override
    public Cat[] getAllCat() {
        return CatDatabase.getCats();
    }
}
