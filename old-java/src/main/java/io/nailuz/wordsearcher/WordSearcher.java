package main.java.io.nailuz.wordsearcher;

import java.io.IOException;
import java.util.*;

public class WordSearcher {
    private Hashtable<String, Set<String>> hashtable;

    public WordSearcher() throws IOException, ClassNotFoundException {
        hashtable = SearcherService.getCurrentHashTable();
    }

    public List<Set<String>> findFiles(String[] desiredWords) {
//        Set<String> results = new TreeSet<>();
        List<Set<String>> filesNamesList = new ArrayList<>();
        for(String word : desiredWords) {
            filesNamesList.add(this.hashtable.get(word));
        }
//        filesNamesList.forEach(results::retainAll);
        return filesNamesList;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double t0 = System.currentTimeMillis();
        WordSearcher ws = new WordSearcher();
        double t1 = System.currentTimeMillis();
//        List<Set<String>> results = ws.findFiles(args);
//        System.out.println(results.size());
        for (Set<String> file : ws.findFiles(args)) {
            System.out.println(file);
        }
        System.out.println(ws);
        double t2 = System.currentTimeMillis();
        System.out.println((t1 - t0) + ", " + (t2 - t1) + " total: " + (t2 - t0) + "ms");
    }
}
