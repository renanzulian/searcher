package test.java.io.nailuz.wordsearcher;

import main.java.io.nailuz.wordsearcher.SearcherService;
import main.java.io.nailuz.wordsearcher.WordSearcher;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class SearcherServiceTest {

    @Test
    public void testGenerateHashTable() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL pathToSampleDirectory = classLoader.getResource("test/resources/sampleFiles");
        if (pathToSampleDirectory == null)
            fail("Sample directory not found");
        File sampleDirectory = new File(pathToSampleDirectory.getFile());
        Hashtable<String, Set<String>> sampleHash = SearcherService.generateHashTable(sampleDirectory);
        Set<String> allFiles = new TreeSet<>();
        for(Set<String> filesWithWord: sampleHash.values()) {
            allFiles.addAll(filesWithWord);
        }
        assertEquals(13, allFiles.size(), "Should have 13 files");
    }

    @Test
    public void performanceTest() throws IOException, ClassNotFoundException {
        String[] args = {"walt", "disney"};
        double t0 = System.currentTimeMillis();
        WordSearcher.main(args);
        double t1 = System.currentTimeMillis();
        double performance = t1 - t0;
        String errorMessage = "Execution should be at more 10ms, but get " + performance + "ms";
        assertTrue(performance <= 10, errorMessage);
    }

}