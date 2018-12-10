package com.jayshollenberger.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LoadTextFile {

    public static List<String> loadFile(String filename) {

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.lines(Paths.get(LoadTextFile.class.getClassLoader()
                    .getResource(filename).toURI()))
                    .collect(toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        loadFile("day2.txt").stream().forEach(System.out::println);
    }

}
