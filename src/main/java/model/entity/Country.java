package model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private Integer id;
    private String name;
    private Integer population;

    public Country(Integer id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Country(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public Country(){}

    @Override
    public String toString() {
        return "\n\nCountry id: " + id + ", country name: " + name + ", country population: " + population;
    }
}
