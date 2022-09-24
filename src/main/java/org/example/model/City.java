package org.example.model;

public class City {
    private int id;
    private String name;
    private int people_id;
    private int country_id;

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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", people_id=" + people_id +"\n"+
                ", country_id=" + country_id +"\n"+
                '}'+"\n";
    }
}
