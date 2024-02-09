package com.vtxlab.bootcamp.bootcampsbfakedatabase.database;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public class CatDatabase {

    private static Cat[] cats;

    private static final int dbLength = 10;

    static {
        cats = new Cat[10];
        cats[0] = new Cat("John", 2);
        cats[1] = new Cat("Mary", 2);
    }

    public static Cat getCat(int index) {
        if (index < 0 || index > dbLength - 1)
            throw new IllegalArgumentException();
        return cats[index];
    }

    public static Cat setCat(int index, Cat cat) {
        if (index < 0 || index > dbLength - 1)
            throw new IllegalArgumentException();
        cats[index] = cat;
        return cat;
    }

    // public static Cat removeCat(int index) {
    //     if (index < 0 || index > dbLength - 1)
    //         throw new IllegalArgumentException();
    //     Cat cat = cats[index];
    //     // re-arrange the array?
    //     return cat;
    // }

    // public static Cat updateCat(int index, Cat cat) {
    //     if (index < 0 || index > dbLength - 1)
    //         throw new IllegalArgumentException();
    //     return setCat(index, cat);
    // }

    public static Cat setCatName(int index, String name) {
        if (index < 0 || index > dbLength - 1)
            throw new IllegalArgumentException();
        if (name == null)
            throw new IllegalArgumentException();
        cats[index].setName(name);
        return cats[index];
    }

    public static Cat setCatAge(int index, int age) {
        if (index < 0 || index > dbLength - 1)
            throw new IllegalArgumentException();
        if (age < 0)
            throw new IllegalArgumentException();
        cats[index].setAge(age);
        return cats[index];
    }

    public static Cat[] getCats(){
        return cats;
    }
}
