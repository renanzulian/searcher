import io.nailuz.WordSearcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordSearcherTest {

    @Test
    public void performanceTest() {
        WordSearcher ws = new WordSearcher(getClass().getClassLoader());
        double startTime = System.currentTimeMillis();
        String[] wordsToSearch = {"hero"};
        ws.search(wordsToSearch);
        double performanceTime = System.currentTimeMillis() - startTime;
        String messageError = "Should performance at most 10ms, but get " + performanceTime + "ms";
        assertTrue(performanceTime <= 10, messageError);
    }

    @Test
    public void withoutWordsProvided() {
        WordSearcher ws = new WordSearcher(getClass().getClassLoader());
        String[] words = new String[0];
        Set<String> results = ws.search(words);
        assertEquals(0, results.size());
    }

    @Test
    public void withUnavailableWord() {
        WordSearcher ws = new WordSearcher(getClass().getClassLoader());
        String[] words = {"renanzulian"};
        Set<String> results = ws.search(words);
        assertEquals(0, results.size());
    }

    @Test
    public void withValidWords() {
        WordSearcher ws = new WordSearcher(getClass().getClassLoader());
        String[] words = {"bellator"};
        Set<String> results = ws.search(words);
        assertTrue(results.contains("example/bellator-10.txt"));
        assertEquals(9, results.size());
    }

    @Test
    public void withManyWords() {
        WordSearcher ws = new WordSearcher(getClass().getClassLoader());
        String[] words = {"peter", "man"};
        Set<String> results = ws.search(words);
        assertEquals(1, results.size());
    }

}