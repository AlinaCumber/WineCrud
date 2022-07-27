package com.wine.winecrud.entity;


import javax.persistence.*;

@Entity
@Table(name = "region")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private String country;

    public RegionEntity(int id, String name, String country) {
        Id = id;
        this.name = name;
        this.country = country;
    }

    public RegionEntity() {
    }

    public RegionEntity(String name, String country) {
        this.name = name;
        this.country = country;
    }

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
