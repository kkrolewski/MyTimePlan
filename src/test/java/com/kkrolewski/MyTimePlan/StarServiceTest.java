package com.kkrolewski.MyTimePlan;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StarServiceTest {

    private final StarService starService = new StarService();

    @Test
    public void findClosestStarsTest(){
    List<Star> stars = new ArrayList<>();

    Star star1 = new Star("BBB" , 50000L);
    Star star2 = new Star("VVV" , 40000L);
    Star star3 = new Star("ZZZ" , 10000L);
    Star star4 = new Star("CCC" , 30000L);
    Star star5 = new Star("XXX" , 20000L);

    stars.add(star1);
    stars.add(star2);
    stars.add(star3);
    stars.add(star4);
    stars.add(star5);

    List<Star> testStars = starService.findClosestStars(stars,3);

    assertEquals(3, testStars.size());
    assertEquals(10000L, testStars.get(0).getDistance());
    assertEquals("ZZZ", testStars.get(0).getName());
    assertEquals(20000L, testStars.get(1).getDistance());
    assertEquals("XXX", testStars.get(1).getName());
    assertEquals(30000L, testStars.get(2).getDistance());
    assertEquals("CCC", testStars.get(2).getName());
    }

    @Test
    public void getNumberOfStarsByDistancesTest(){
        List<Star> stars = new ArrayList<>();

        Star star1 = new Star("BBB" , 50000L);
        Star star2 = new Star("VVV" , 40000L);
        Star star3 = new Star("ZZZ" , 10000L);
        Star star4 = new Star("CCC" , 30000L);
        Star star5 = new Star("XXX" , 30000L);

        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        Map<Long, Integer> testStars = starService.getNumberOfStarsByDistances(stars);
        assertEquals(4, testStars.size());
        assertEquals(1, testStars.get(10000L));
        assertEquals(2, testStars.get(30000L));
        assertEquals(1, testStars.get(50000L));
        assertEquals(1, testStars.get(40000L));
        assertNull(testStars.get(70000L));
    }

    @Test
    public void  getUniqueStarsTest(){
        List<Star> stars = new ArrayList<>();

        Star star1 = new Star("BBB" , 50000L);
        Star star2 = new Star("BBB" , 40000L);
        Star star3 = new Star("ZZZ" , 10000L);
        Star star4 = new Star("ZZZ" , 30000L);
        Star star5 = new Star("CCC" , 30000L);
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        Collection<Star> testStars = starService.getUniqueStars(stars);
        assertEquals(1, testStars.size());
        assertTrue(testStars.contains(star5));
        assertFalse(testStars.contains(star3));
        assertFalse(testStars.contains(star4));


    }
}
