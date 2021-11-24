package model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Artist {

    private Integer id;
    private String name;
    private String last_name;
    private Integer age;
    private Integer amount_of_albums;


    public Artist(Integer id, String name, String last_name, Integer age, Integer amount_of_albums) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.amount_of_albums = amount_of_albums;

    }

    public Artist(String name, String last_name, Integer age,
                  Integer amount_of_albums) {
        this(null, name, last_name, age, amount_of_albums);
    }

    @Override
    public String toString() {
        return "\n\nSinger: id: " + id + ", name: " + name + ", last_name: " + last_name + ", age: " + age +
                ", amount_of_albums: " + amount_of_albums;
    }
}