package edu;

import java.util.Set;

public class BuilderPerson {

    private String name = "John Doe";
    private String surname;
    private int age;
    private int height;
    private int weight;
    private Set<Person> parents;

    public BuilderPerson() {
    }

    public BuilderPerson withName(String name) {
        this.name = name;
        return this;
    }

    public BuilderPerson withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public BuilderPerson withAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderPerson withHeight(int height) {
        this.height = height;
        return this;
    }

    public BuilderPerson withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public BuilderPerson withParent(Set<Person> parents) {
        this.parents = parents;
        return this;
    }

    public Person build() {
        return new Person(name, surname, age, height, weight, parents);
    }
}
