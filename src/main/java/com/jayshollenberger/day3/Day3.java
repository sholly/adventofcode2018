package com.jayshollenberger.day3;

import com.jayshollenberger.util.LoadTextFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        HashMap<Integer, Integer> idMap = new HashMap<>();

        Integer sumBeforeSquare = 0;
        for (Square one : squares) {
            for (Square two : squares) {
                idMap.put(one.id(), two.id());
                if (!two.id().equals(one.id()) &&
                        ((!idMap.containsKey(one.id()) && !idMap.containsValue(two.id())) ||
                                (!idMap.containsKey(two.id())) && !idMap.containsValue(one.id())) &&

                        (one.startX() < two.startX() || one.startY() < two.startY()) &&
                        one.endX() > two.startX() && one.endY() > two.startY()
                ) {
                    System.out.println(one);
                    System.out.println(two);
                    int x = Math.abs(two.startX() - one.startX());
                    int y = Math.abs(two.startY() - one.startY());
                    System.out.println(x);
                    System.out.println(y);
                    sumBeforeSquare += (x + y);
                    System.out.println(sumBeforeSquare);

                }
            }
        }
        return sumBeforeSquare;
    }

    public static void main(String[] args) {
        int squareInches = overlap(parseInput());
        System.out.println(squareInches);

    }
}
