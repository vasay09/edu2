package edu;

import java.util.Set;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final int height;
    private final int weight;
    private final Set<Person> parents;

    public Person (String name, String surname, int age, int height, int weight,  Set<Person> parents) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.parents = parents;
    }

    //simple, next going builder

    //    Person (String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    Person (String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//
//    Person (String name, String surname, int age, int height) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.height = height;
//    }
}
