package test.java.io.nailuz.moviesearcher;

import main.java.io.nailuz.moviesearcher.MovieSearcher;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieSearcherTest {

    @Test
    public void performanceTest() throws FileNotFoundException {
        String[] args = {"disney"};
        InputStream input = new FileInputStream("movies.txt");
        double startTime = System.currentTimeMillis();
        MovieSearcher searcher = new MovieSearcher(input);
        double instantiateTime = System.currentTimeMillis();
        searcher.searchMovies(Arrays.asList(args));
        double finishTime = System.currentTimeMillis();
        double loadFileTime = instantiateTime - startTime;
        double searchTime = finishTime - instantiateTime;
        double searchPerformance = loadFileTime + searchTime;
        String messageError = "Load file performance: " + loadFileTime + " ms\n" +
                              "Search performance: " + searchTime + " ms\n" +
                              "Performance should be at most 10 ms, but performed with " + searchPerformance + " ms";
        assertTrue(searchPerformance <= 10, messageError);
    }
}