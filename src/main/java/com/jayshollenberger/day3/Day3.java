package com.jayshollenberger.day3;

import com.jayshollenberger.util.LoadTextFile;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day3 {

    static List<Square> parseInput() {
        List<String> rawLines = LoadTextFile.loadFile("day3.txt");

        List<Square> squares = new ArrayList<>();
        rawLines.forEach(line -> {
            Integer id = Integer.valueOf(line.split("@")[0].replaceAll("[#|@|\\s+]", ""));
            String afterAt = line.split("@")[1];
            String[] stuff = afterAt.split(":");

            String[] positions = stuff[0].split(",");
            String[] sizes = stuff[1].split("x");

            Integer positionX = Integer.valueOf(positions[0].trim());
            Integer positionY = Integer.valueOf(positions[1].trim());

            Integer sizeX = Integer.valueOf(sizes[0].trim());
            Integer sizeY = Integer.valueOf(sizes[1].trim());

            Square s = new Square(id, positionX, positionY, sizeX, sizeY);
            squares.add(s);
        });
        return squares;
    }

    public static int overlap(List<Square> squares) {

        HashMap<Point, Integer> fabric = new HashMap<>();

        overlapFabric(squares, fabric);

        return fabric.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()).size();

    }

    public static int noOverlap(List<Square> squares) {

        HashMap<Point, Integer> fabric = new HashMap<>();

        overlapFabric(squares, fabric);

        int id = 0;
        for (Square square : squares) {
            boolean overlap = false;
            for (int dx = square.startX(); dx <= square.endX(); dx++) {
                for (int dy = square.startY(); dy <= square.endY(); dy++) {
                    if (fabric.get(new Point(dx,dy)) > 1) {
                        overlap = true;
                    }
                }
            }
            if(!overlap) {
                id = square.id();
            }
        }
        return id;
    }

    private static void overlapFabric(List<Square> squares, HashMap<Point, Integer> fabric) {
        for (Square square : squares) {

            for (int dx = square.startX(); dx <= square.endX(); dx++) {
                for (int dy = square.startY(); dy <= square.endY(); dy++) {
                    if (!fabric.containsKey(new Point(dx, dy))) {
                        fabric.put(new Point(dx, dy), 1);
                    } else {
                        int current = fabric.get(new Point(dx, dy));
                        current += 1;
                        fabric.put(new Point(dx, dy), current);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int squareInches = overlap(parseInput());
        System.out.println(squareInches);
        int id = noOverlap(parseInput());
        System.out.println(id);

    }
}


