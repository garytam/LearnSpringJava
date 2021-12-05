package com.gtc.learn.hashCode;

import com.gtc.learn.hashCode.model.Movie;
import com.gtc.learn.hashCode.model.MovieNoHashCode;

import java.util.HashMap;

public class HashCodePerformance {

    private void demo1(){
        HashMap<MovieNoHashCode, String> movieMap = new HashMap<MovieNoHashCode, String>();

        for (int i = 0; i <= 10000; i++){
            movieMap.put(new MovieNoHashCode("name" + i), "directory " + 1);
        }

        long start = (long) System.currentTimeMillis();
        for (int i = 0; i <= 10000; i++) {
            movieMap.get(new MovieNoHashCode("name" + i));
        }
        System.out.println("Time to find movie is " + (System.currentTimeMillis() - start) + " ms . ");
    }

    private void demo2(){
        HashMap<Movie, String> movieMap = new HashMap<Movie, String>();

        for (int i = 0; i <= 10000; i++){
            movieMap.put(new Movie("name" + i), "directory " + 1);
        }

        long start = (long) System.currentTimeMillis();
        for (int i = 0; i <= 10000; i++) {
            movieMap.get(new Movie("name" + i));
        }
        System.out.println("Time to find movie is " + (System.currentTimeMillis() - start) + " ms . ");
    }

    public static void main(String[] args) {
        HashCodePerformance demo = new HashCodePerformance();
        demo.demo1();
        demo.demo2();
    }
}
