package edu;

public class Entity {
    volatile int id;
    String name;
    public transient long random;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
