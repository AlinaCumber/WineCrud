package com.wine.winecrud.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "region")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
