package org.example.model;

public class Country {
    private int id;
    private String name;
    private int people_id;


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

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", people_id=" + people_id +"\n"+
                '}'+"\n";
    }
}
