import io.nailuz.WordSearcher;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordSearcherTest {
    WordSearcher ws = new WordSearcher();

    @Test
    public void performanceTest() {
        double startTime = System.currentTimeMillis();
        String[] wordsToSearch = {"hero"};
        this.ws.search(wordsToSearch);
        double performanceTime = System.currentTimeMillis() - startTime;
        String messageError = "Should performance at most 10ms, but get " + performanceTime + "ms";
        assertTrue(performanceTime <= 10, messageError);
    }

    @Test
    public void withoutWordsProvided() {
        String[] words = new String[0];
        Set<String> results = this.ws.search(words);
        assertEquals(0, results.size());
    }

    @Test
    public void withWordNoAvailable() {
        String[] words = {"renanzulian"};
        Set<String> results = this.ws.search(words);
        assertEquals(0, results.size());
    }

    @Test
    public void withValidWords() {
        String[] words = {"walt", "disney"};
        Set<String> results = this.ws.search(words);
        assertEquals(53, results.size());
        assertTrue(results.contains("movies/data/dog-watch.txt"));
    }

    @Test
    public void withInexistentsWords() {
        String[] words = {"renan"};
        Set<String> results = this.ws.search(words);
        assertEquals(0, results.size());
    }
}