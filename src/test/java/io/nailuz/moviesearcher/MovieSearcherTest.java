package test.java.io.nailuz.moviesearcher;

import main.java.io.nailuz.moviesearcher.MovieSearcher;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MovieSearcherTest {

    @Test
    public void performanceTest() {
        String[] args = {"disney"};

        double startTime = System.currentTimeMillis();
        try {
            MovieSearcher.main(args);
        } catch (FileNotFoundException e) {
            fail();
        }
        double finishTime = System.currentTimeMillis();
        assertTrue(finishTime - startTime <= 10);
    }
}