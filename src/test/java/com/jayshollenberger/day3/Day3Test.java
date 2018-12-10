package com.jayshollenberger.day3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Day3Test {

    @Test
    public void overlap_whenbothAre4_() {
        Square one = new Square(1,1,3,4,4);
        Square two = new Square(2,3,1,4,4);
        Square three = new Square(3,5,5,2,2);

        List<Square> squares = Arrays.asList(one,two, three);

        assertEquals(4, Day3.overlap(squares));
    }

    @Test
    public void replaceAllTest() {

        String initial = "#1112 @";

        String actual = initial.replaceAll("[#|@|\\s+]", "");
        assertEquals("1112", actual);
    }
}