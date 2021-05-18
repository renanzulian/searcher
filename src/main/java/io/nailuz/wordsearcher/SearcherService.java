package main.java.io.nailuz.wordsearcher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class SearcherService {
    public static Hashtable<String, Set<String>> generateHashTable(File parentDirectoryOfFiles) throws IOException {
        File[] files = parentDirectoryOfFiles.listFiles();
        if (files == null)
            throw new NoSuchFileException("The directory is empty");
        Hashtable<String, Set<String>> hashtable = new Hashtable<>();
        for(File file: files) {
            List<String> fileLines = Files.readAllLines(file.toPath());
            for(String rawLine: fileLines) {
                String cleanedLine = rawLine.replaceAll(" +", " ").toLowerCase(Locale.US).strip();
                String[] lineWords = cleanedLine.split(" ");
                for(String word: lineWords) {
                    Set<String> filesWithWord = hashtable.containsKey(word) ? hashtable.get(word) : new TreeSet<>();
                    filesWithWord.add(file.getName());
                    hashtable.put(word, filesWithWord);
                }
            }
        }
        return hashtable;
    }

    private static void saveHashTableAsBin(Hashtable<String, Set<String>> hashtable) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("hash.bin"));
        output.writeObject(hashtable);
        output.close();
    }

    public static Hashtable<String, Set<String>> getCurrentHashTable() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("hash.bin"));
        Hashtable<String, Set<String>> currentHashtable = (Hashtable<String, Set<String>>) input.readObject();
        input.close();
        return currentHashtable;
    }

    public static void main(String[] args) throws IOException {
        String filePath = args.length > 0 ? args[0] : "files";
        File directory = new File(filePath);
        Hashtable<String, Set<String>> hashtable = generateHashTable(directory);
        System.out.println("Generated hashtable with " + hashtable.size() + " words");
        saveHashTableAsBin(hashtable);
    }
}
