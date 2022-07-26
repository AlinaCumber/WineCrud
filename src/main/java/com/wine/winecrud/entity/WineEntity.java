package com.wine.winecrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "wine")
public class WineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String year;
    private float rating;
    private int num_reviews;
    private float price;
    private String body;
    private String acidity;
    private int winery_id;
    private int type_id;
    private int region_id;

    private String type;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public int getWinery_id() {
        return winery_id;
    }

    public void setWinery_id(int winery_id) {
        this.winery_id = winery_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
}
