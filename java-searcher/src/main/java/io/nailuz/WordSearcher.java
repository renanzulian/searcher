package io.nailuz;

import java.io.*;
import java.util.*;

public class WordSearcher {
    ClassLoader classLoader;

    public WordSearcher() {
        this.classLoader = getClass().getClassLoader();
    }

    public Set<String> search(String[] words) {
        List<Set<String>> contents = new ArrayList<>();
        for (String word : words) {
            contents.add(getContents(word.toLowerCase(Locale.US)));
        }
        if (contents.size() > 0) {
            Set<String> fileNames = new TreeSet<>(contents.get(0));
            contents.forEach(fileNames::retainAll);
            return fileNames;
        } else {
            return new TreeSet<>();
        }

    }

    private Set<String> getContents(String fileName) {
        Set<String> results = new TreeSet<>();
        try {
            InputStream is = this.classLoader.getResourceAsStream( fileName + ".txt");
            if (is == null)
                throw new IOException();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String content;
            if ((content = reader.readLine()) != null) {
                results.addAll(Arrays.asList(content.split(" ")));
            }
            reader.close();
        } catch (Exception ignored){ }
        return results;
    }

    public static void main(String[] args){
        WordSearcher ws = new WordSearcher();
        Set<String> fileNames = ws.search(args);
        System.out.println("Foram encontradas " + fileNames.size() + " ocorrências pelo termo.");
        System.out.println("Os arquivos que possuem '" + String.join(" ", args) + "' são:");
        System.out.println(String.join("\n", fileNames));
    }

}
