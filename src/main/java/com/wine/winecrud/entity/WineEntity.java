package com.wine.winecrud.entity;


import com.wine.winecrud.validation.MaxCurrentYear;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "wine")
public class WineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Year is mandatory")
    @Min(1900)
    @MaxCurrentYear
    private String year;

    @NotNull( message = "rating is mandatory")
    @Min(0)
    @Max(5)
    private float rating;

    @NotNull( message = "Number of reviews is mandatory")
    @Min(0)
    private int num_reviews;

    @NotNull( message = "Price is mandatory")
    @Min(0)
    private float price;

    @NotBlank(message = "Body is mandatory")
    @Min(1)
    @Max(5)
    private String body;

    @NotBlank(message = "Acidity is mandatory")
    @Min(1)
    @Max(5)
    private String acidity;

    @NotNull( message = "Winery id is mandatory")
    @Min(0)
    private int winery_id;


    @NotNull( message = "Type id is mandatory")
    @Min(0)
    private int type_id;

    @NotNull( message = "Region id is mandatory")
    @Min(0)
    private int region_id;

    @NotBlank(message = "Type is mandatory")
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
