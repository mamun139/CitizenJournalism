package com.example.mamun.citizenjournalism;

/**
 * Created by Mamun on 07-04-18.
 */

public class DataTemp {
    private int id;
    private String date;
    private String location;
    private String description;

    public DataTemp(String date, String location, String description) {
        this.date = date;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
