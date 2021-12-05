package com.gtc.learn.java.operation;

import com.gtc.learn.java.model.Movie;
import com.gtc.learn.java.util.MoviesUtil;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMovies {

    @Test
    private void countNumberOfMovies(){
        List<Movie> movieList = MoviesUtil.createMovies();

        Long totalNumberOfMovies = movieList.stream().count();
        assertEquals(17, totalNumberOfMovies);
    }

    @Test
    private void totalSpielbergBoxOffice(){
        List<Movie> movieList = MoviesUtil.createMovies();
        double totalBoxOffice = movieList.stream().
                filter(movie -> "Spielberg".equals(movie.getDirector())).
                mapToDouble(Movie::getBoxOffice).
                sum();

        assertEquals(1800.5, totalBoxOffice);
    }

    @Test
    private void highestGross(){
        List<Movie> movieList = MoviesUtil.createMovies();

        Movie highestGrossMovie = movieList.stream().
                max(Comparator.comparing(Movie::getBoxOffice)).
                get();

        System.out.println(highestGrossMovie);
    }

    public static void main(String[] args) {
        CountMovies counter = new CountMovies();
        counter.countNumberOfMovies();
        counter.totalSpielbergBoxOffice();
        counter.highestGross();
    }
}
