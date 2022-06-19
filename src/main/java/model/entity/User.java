package model.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class User {

    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private Integer age;
    private Integer country_id;
    private Integer library_id;


    public User(Integer id, String name, String last_name, String email,
                Integer age, Integer country_id, Integer library_id) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.country_id = country_id;
        this.library_id = library_id;
    }

    public User(String name, String last_name, String email,
                Integer age, Integer country_id, Integer library_id) {
        this(null, name, last_name, email,
                age, country_id, library_id);
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", name: " + name + ", last_name: " + last_name + ", email: " + email +
                ", age: " + age + ", country_id: " + country_id + ", library_id: " + library_id;
    }
}