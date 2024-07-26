package com.kkrolewski.MyTimePlan;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/stars")
public class StarController {

    private final StarService starService = new StarService();
    private final Map<Integer, Star> stars = new HashMap<>();

    @PostMapping
    public Star addStar(@RequestBody Star star){
        if(stars.containsKey(star.getId())){
            throw new NoSuchElementException("Star with that id already exist");
        }
        stars.put(star.getId(), star);
        return star;

    }

    @GetMapping("/{id}")
    public Star getStar(@PathVariable Integer id){
        if(stars.get(id) == null){
            throw new NoSuchElementException("Star with that id doesn't exist");
        }
        return stars.get(id);
    }

    @PutMapping("/{id}")
    public Star updateStar(@PathVariable Integer id, @RequestBody Star star) {
        Star starCopy = stars.get(id);
        if(starCopy != null){
            starCopy.setName(star.getName());
            starCopy.setDistance(star.getDistance());
            return starCopy;
        }
        throw new NoSuchElementException("Star with that id doesn't exist");
    }

    @DeleteMapping("/{id}")
    public void deleteStar(@PathVariable Integer id){
        stars.remove(id);
    }

    @GetMapping("/findClosestStars")
    public List<Star> findClosestStars(@RequestParam int size){
        List<Star> temp = starService.findClosestStars(new ArrayList<>(stars.values()), size);
        if(temp.size() == 0){
            throw new NoSuchElementException("Stars database is empty");
        }
        return temp;
    }

    @GetMapping("/getNumberOfStarsByDistances")
    public Map<Long, Integer> getNumberOfStarsByDistances() {
        Map<Long, Integer> temp = starService.getNumberOfStarsByDistances(new ArrayList<>(stars.values()));
        if(temp.size() == 0){
            throw new NoSuchElementException("Stars database is empty");
        }
        return temp;
    }

    @GetMapping("/getUniqueStars")
    public Collection<Star> getUniqueStars() {
        Collection<Star> temp = starService.getUniqueStars(new HashSet<>(stars.values()));
        if(temp.size() == 0){
            throw new NoSuchElementException("Stars database is empty");
        }
        return temp;
    }
}
