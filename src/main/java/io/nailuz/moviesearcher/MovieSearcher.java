package main.java.io.nailuz.moviesearcher;

import java.io.*;
import java.util.*;


public class MovieSearcher {
    private final Scanner movies;

    public MovieSearcher(InputStream movies) {
        this.movies = new Scanner(movies);
    }

    public ArrayList<String> searchMovies(List<String> words) {
        ArrayList<String> results = new ArrayList<>();
        while (this.movies.hasNext()) {
            String movie = this.movies.nextLine();
            boolean movieContainsWords = words.stream().anyMatch(movie::contains);
            if (movieContainsWords) {
                results.add(movie.split("->")[0]);
            }
        }
        this.movies.close();
        return results;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(args));
        InputStream input = new FileInputStream("movies.txt");
        MovieSearcher searcher = new MovieSearcher(input);
        ArrayList<String> results = searcher.searchMovies(words);
        System.out.println(results.size() + " movies founded:");
        results.forEach(System.out::println);
    }

}
