package com.gtc.learn.hashCode.model;

import java.util.List;
import java.util.Objects;

public class Movie {

    public Movie(String name){
        this.movieName = name;
    }
    private String movieName;
    private List<String> actors;
    private double boxOffice;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", actors=" + actors +
                ", boxOffice=" + boxOffice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.boxOffice, boxOffice) == 0 && Objects.equals(movieName, movie.movieName) && Objects.equals(actors, movie.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, actors, boxOffice);
    }
}
