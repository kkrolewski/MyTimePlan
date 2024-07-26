package com.kkrolewski.MyTimePlan;

import java.util.*;

public class StarService {

    public static List<Star> findClosestStars(List<Star> stars, int size){
        List<Star> starsCopy = new ArrayList<>(stars);
        starsCopy.sort(Comparator.comparing(Star::getDistance, Comparator.naturalOrder()));
        return starsCopy.subList(0,size);
    }

    public static Map<Long, Integer> getNumberOfStarsByDistances(List<Star> stars){
        Map<Long, Integer> starsMap = new TreeMap<Long, Integer>();
        List<Star> starsCopy = new ArrayList<>(stars);
        starsCopy.sort(Comparator.comparing(Star::getDistance, Comparator.naturalOrder()));
        for (Star star : starsCopy) {
            if (starsMap.containsKey(star.getDistance())) {
                Integer value = starsMap.get(star.getDistance());
                starsMap.replace(star.getDistance(), (value+1));
            } else {
                starsMap.put(star.getDistance(), 1);
            }
        }
        return starsMap;
    }

    public static Collection<Star> getUniqueStars(Collection<Star> stars) {
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicatedNames = new HashSet<>();
        Collection<Star> uniqueStars = new HashSet<>();

        for (Star star : stars) {
            if (!uniqueNames.add(star.getName())) {
                duplicatedNames.add(star.getName());
            }
        }

        for (Star star : stars) {
            if (!duplicatedNames.contains(star.getName())) {
                uniqueStars.add(star);
            }
        }

        return uniqueStars;
    }
}