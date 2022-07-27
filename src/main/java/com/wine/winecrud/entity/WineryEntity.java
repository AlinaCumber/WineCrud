package com.wine.winecrud.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "winery")
public class WineryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @NotBlank(message = "Name is mandatory")
    private String name;

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
