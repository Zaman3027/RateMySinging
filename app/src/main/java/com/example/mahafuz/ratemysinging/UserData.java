package com.example.mahafuz.ratemysinging;

public class UserData {
    String name;
    int age;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserData(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;

    }

    public UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
