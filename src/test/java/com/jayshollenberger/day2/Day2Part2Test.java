package com.jayshollenberger.day2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Day2Part2Test {

    @Test
    public void part2() {
        List<String> ids = Arrays.asList("abcde", "abcdf");

        String actual1 = Day2Part2.part2(ids);
        assertEquals("abcd", actual1 );
    }

}