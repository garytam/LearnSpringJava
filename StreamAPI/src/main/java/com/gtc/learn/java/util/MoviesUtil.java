package com.gtc.learn.java.util;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.gtc.learn.java.model.Movie;

public class MoviesUtil {

   public static List<Movie> filterMovie(List<Movie> movies, Predicate<Movie>predicate){
      return movies.stream()
              .filter(predicate)
              .collect(Collectors.toList());
   }

   public static List<Movie> filterMovieDirectorYear(List<Movie> movies, BiPredicate<String, Integer> biPredicate){
      return movies.stream()
              .filter(x -> biPredicate.test(x.getDirector(), x.getReleaesYear()))
              .collect(Collectors.toList());
   }

   public static List<Movie> filterMovieDirectorBoxOffice(List<Movie> movies, BiPredicate<String, Double> biPredicate){
      return movies.stream()
              .filter(x -> biPredicate.test(x.getDirector(), x.getBoxOffice()))
              .collect(Collectors.toList());
   }

   private static List<String> countryList1(){
      List<String> countries = Arrays.asList("US", "Canada", "Mexico");
      return countries;
   }

   private static List<String> countryList2(){
      List<String> countries = Arrays.asList("US", "Canada", "China", "Japan", "Hong Kong");
      return countries;
   }

   private static List<String> countryListAsia(){
      List<String> countries = Arrays.asList("China", "Japan", "Hong Kong", "Taiwan", "Singapore");
      return countries;
   }

   public static List<Movie> createMovies(){
      List<Movie> movies = new ArrayList<Movie>();
      movies.add(new Movie("Star Trek: The Motion Picture","Robert Wise", 1979, 139.0, countryList1()));
      movies.add(new Movie("Start Trek: Into Darkness", "JJ Abrams", 2013, 467.4, countryList2()));

      movies.add(new Movie("Harry Porter and the Sorcerer's Stone", "Chris Columbus", 2001, 1001.2, countryListAsia()));
      movies.add(new Movie("American Graffiti", "Lucas", 1973, 597.8, countryList1()));
      movies.add(new Movie("Star War: Revenge of the Sith", "Lucas", 2005, 850.0, countryList2()));
      movies.add(new Movie("Star War: The Phantom Menace", "Lucas", 1999, 1027.0, countryListAsia()));

      movies.add(new Movie("Raiders of the Lost Ark", "Lucas", 1981, 248.2, countryList1()));
      movies.add(new Movie("Indiana Jones and the Temple of Doom", "Lucas", 1984, 248.2, countryList1()));
      movies.add(new Movie("Howard the duck", "Lucas", 1986, 137.0, countryList1()));
      movies.add(new Movie("ET", "Spielberg", 1982, 792.1, countryList2()));
      movies.add(new Movie("Jurassic Park", "Spielberg", 1993, 402.5, countryListAsia()));
      movies.add(new Movie("Close encounter of the third kind", "Spielberg", 1977, 135.2, countryList1()));
      movies.add(new Movie("Jaws", "Spielberg", 1975, 470.7, countryList2()));

      movies.add(new Movie("Avatar", "Cameroon", 2009, 2788.0, countryListAsia()));
      movies.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012, 1021.1, countryList1()));

      movies.add(new Movie("Avengers: Endgame", "Russo", 2019, 2797.8, countryList2()));
      movies.add(new Movie("God Father part II", "Coppola", 1975, 2345.7, countryList2()));

      return movies;
   }

   public static Map<String, List<Movie>> createMoivesByDirector(){
      Map<String, List<Movie>> result = new HashMap<>();

      List<Movie> movieList = MoviesUtil.createMovies();
      movieList.forEach( movie -> {
         List<Movie> movies = result.get(movie.getDirector());
         if (movies == null){
            movies = new ArrayList<>();
         }
         movies.add(movie);
         result.put(movie.getDirector(), movies);
      });


      return result;
   }
}
