package com.gtc.learn.java.model;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie implements Serializable {
    private String title;
    private String director;
    private Integer releaesYear;
    private Double boxOffice;
    private List<String> releasedCountries;

    public Movie() {}

    public Movie(String title){
        this.title = title;
    }

    public Movie(String title, String director, Integer releaesYear, Double boxOffice) {
        this.title = title;
        this.director = director;
        this.releaesYear = releaesYear;
        this.boxOffice = boxOffice;
    }

    public Movie(String title, String director, Integer releaesYear, Double boxOffice, List<String> releasedCountries) {
        this.title = title;
        this.director = director;
        this.releaesYear = releaesYear;
        this.boxOffice = boxOffice;
        this.releasedCountries = releasedCountries;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaesYear=" + releaesYear +
                ", boxOffice=" + boxOffice +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaesYear() {
        return releaesYear;
    }

    public void setReleaesYear(Integer releaesYear) {
        this.releaesYear = releaesYear;
    }

    public Double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public void setReleasedCountries(List<String> countries){
        this.releasedCountries = countries;
    }

    public void addReleaseCountry(String country){
        if (this.releasedCountries == null){
            this.releasedCountries = new ArrayList<String>();
        }
        this.releasedCountries.add(country);
    }
    public List<String> getReleasedCountries(){
        return this.releasedCountries;
    }

    public boolean isMegaHit(){
        return this.boxOffice > 500.0;
    }

    public Object dynamicMethod(String name){
        try {
            PropertyDescriptor pd = new PropertyDescriptor(name, Movie.class);
            Method getter = pd.getReadMethod();
            Object fieldValue = getter.invoke(this);
            return fieldValue;
        } catch (Exception e){
            System.out.printf("Exception --> " + e);
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(director, movie.director) && Objects.equals(releaesYear, movie.releaesYear) && Objects.equals(boxOffice, movie.boxOffice) && Objects.equals(releasedCountries, movie.releasedCountries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, releaesYear, boxOffice, releasedCountries);
    }
}

