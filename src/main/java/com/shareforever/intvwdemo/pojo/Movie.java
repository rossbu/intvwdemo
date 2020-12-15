package com.shareforever.intvwdemo.pojo;

public class Movie implements Comparable<Movie>{

    private int id;
    private String name;
    private int year;
    private double rating;

    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    @Override
    public int compareTo(Movie m){
        return this.name.compareTo(m.getName());

    }

}
