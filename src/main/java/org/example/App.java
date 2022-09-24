package org.example;

import org.example.model.City;
import org.example.model.Country;
import org.example.model.Person;
import org.example.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ATABEK DOSBAEV
 */
public class App {

    public static void main( String[] args ) {
    createTable();
    createTableCity();
    createTableCountry();

    insertTablePeople(1,"Altai Kulginov", 53, "Mer of Astana");
    insertTablePeople(2,"Almaz Mambetov", 46, "Mer of Osh-city");
    insertTablePeople(3,"Aibek Djunushaliev", 52, "Mer of Bishkek");
    insertTablePeople(4,"Akbar Shukurov", 38, "Mer of Samarqand");
    insertTablePeople(5,"Johongir Abidovich", 47, "Mer of Tashkent");

    insertTableCity(1,"Osh",2,1);
    insertTableCity(2,"Astana",1,3);
    insertTableCity(3,"Bishkek",3,1);
    insertTableCity(4,"Samarqand",4,2);
    insertTableCity(5,"Tashkent",5,2);

    insertTableCountry(1,"Kyrgyzstan",1);
    insertTableCountry(2,"Uzbekistan",2);
    insertTableCountry(3,"Kazakhstan",1);

    List<Person> allPeople = getAllPeople();
    System.out.println(allPeople);

    List<City> allCities = getAllCity();
    System.out.println(allCities);

    List<Country> allCountries = getAllCountries();
    System.out.println(allCountries);

    System.out.println(idMenenTabuu(2));

    }

    public static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS people(" +
                " id INT PRIMARY KEY ," +
                " name VARCHAR(40) NOT NULL ," +
                " age INT," +
                " position VARCHAR(40) NOT NULL);";
        try (
                Connection conn = DB.connection();
                Statement statement = conn.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("create table is successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> getAllPeople(){
        String sql = "SELECT * FROM people";
        List<Person> people = new ArrayList<>();
        try (Connection connection = DB.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Person person = new Person();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                person.setId(id);
                person.setName(name);
                person.setAge(age);
                person.setPosition(position);
                people.add(person);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return people;
    }

    public static void insertTablePeople(int id,String name,int age, String position){
        String sql = "Insert into people(id,name,age,position ) values(?,?,?,?)";
        try (Connection connection = DB.connection();
         PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,age);
            statement.setString(4,position);
            statement.executeUpdate();
            System.out.println("Successfully added"+name);
        }catch (SQLException e){
           e.printStackTrace();
        }
    }

    public static void createTableCity(){
        String sql = "CREATE TABLE IF NOT EXISTS cities(" +
                "    id INT PRIMARY KEY ," +
                "    name VARCHAR(40) NOT NULL ," +
                "    people_id INT REFERENCES people(id)," +
                "    country_id INT REFERENCES countries(id));";
        try (Connection conn = DB.connection();
        Statement statement = conn.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("create table is successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<City> idMenenTabuu(int id){
    City city = new City();
    String SQL_ID = "SELECT * FROM cities WHERE id =" +id ;
    List<City> cities = new ArrayList<>();
    try(Connection connect = DB.connection();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_ID)){
        while (resultSet.next()){
            city.setId(resultSet.getInt("id"));
            city.setName(resultSet.getString("name"));
            city.setPeople_id(resultSet.getInt("people_id"));
            city.setCountry_id(resultSet.getInt("country_id"));
            cities.add(city);
        }
    }catch (SQLException e){
        System.out.println(e.getMessage() + "Not call by id");
    }

    return cities;
    }


    public static List<City> getAllCity(){
        String sql = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        try (Connection connection = DB.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                City city = new City();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int people_id = resultSet.getInt("people_id");
                int country_id = resultSet.getInt("country_id");
                city.setId(id);
                city.setName(name);
                city.setPeople_id(people_id);
                city.setCountry_id(country_id);
                cities.add(city);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public static void insertTableCity(int id, String name,int people_id,int country_id){
        String sql = "Insert into cities(id,name,people_id,country_id)values(?,?,?,?)";
        try(Connection connection = DB.connection();
            PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,people_id);
            statement.setInt(4,country_id);
            statement.executeUpdate();
            System.out.println("Successfully added"+ name);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void createTableCountry(){
        String sql = "CREATE TABLE IF NOT EXISTS countries(" +
                "    id INT PRIMARY KEY ," +
                "    name VARCHAR(40) NOT NULL ," +
                "    people_id INT REFERENCES people(id));";
        try (Connection conn = DB.connection();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("create table is successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<Country> getAllCountries(){
        String sql = "SELECT * FROM countries";
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DB.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Country country = new Country();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int people_id = resultSet.getInt("people_id");
                country.setId(id);
                country.setName(name);
                country.setPeople_id(people_id);
                countries.add(country);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return countries;
    }
    public static void insertTableCountry(int id, String name, int people_id){
        String sql = "Insert into countries(id,name,people_id)values(?,?,?)";
        try(
                Connection connection = DB.connection();
                PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,people_id);
            statement.executeUpdate();
            System.out.println("Successfully added" + name);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
