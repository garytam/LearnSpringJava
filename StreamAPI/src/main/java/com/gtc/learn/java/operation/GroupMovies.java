package com.gtc.learn.java.operation;

import com.gtc.learn.java.model.Movie;
import com.gtc.learn.java.util.MoviesUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupMovies {

    @Test
    private void numberOfMoviesByDirector(){
        List<Movie> movieList = MoviesUtil.createMovies();

        Map<String, List<Movie>> moviesByDirector = movieList.stream().
                collect(Collectors.groupingBy(Movie::getDirector));

        assertEquals(4, moviesByDirector.get("Spielberg").size());
        assertEquals(6, moviesByDirector.get("Lucas").size());

    }

    @Test
    private void totalBoxOfficeByDirector2(){
        List<Movie> movieList = MoviesUtil.createMovies();

        Map<String, Double> moviesByDirector = movieList.stream().
                collect(Collectors.groupingBy(Movie::getDirector, Collectors.summingDouble(Movie::getBoxOffice)));

        assertEquals(1800.5, moviesByDirector.get("Spielberg"));
        assertEquals(2345.7, moviesByDirector.get("Coppola"));

    }

    public static void main(String[] args) {
        GroupMovies counter = new GroupMovies();
        counter.numberOfMoviesByDirector();
        counter.totalBoxOfficeByDirector2();
    }
}
