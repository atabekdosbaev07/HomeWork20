package org.example.model;

public class Person {
    private int id;
    private String name;
    private int age;
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", age=" + age +"\n"+
                ", position='" + position + '\'' +"\n"+
                '}'+"\n";
    }
}
