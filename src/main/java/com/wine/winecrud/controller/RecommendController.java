package com.wine.winecrud.controller;


import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    WineService wineService;




    @GetMapping("/bang")
    public ResponseEntity<List<WineEntity>> getBestRatedWines(@RequestParam int top){
        List<WineEntity> wines = wineService.topRatingPrice();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }

    /*@GetMapping("/vintage2")
    public ResponseEntity<List<WineEntity>> getVintage(@RequestParam int top) {
        List<WineEntity> wines = wineService.topVintage();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }*/

    /*@GetMapping("/vintage")

    public ResponseEntity<Map<String, List<WineEntity>>> getVintageWine(@RequestParam int top){

        Map<String, List<WineEntity>> map = new HashMap<>();

        wineService.findBestYear(PageRequest.of(0,top)).forEach(s -> map.put(s, wineService.findTopYears(s)));
        List<String> years = wineService.findWineBestYear(top);

        for(String year : years){
            map.put(year, wineService.findByYear(year));
        }
        return new ResponseEntity<>(map, HttpStatus.OK);

    }*/

    @GetMapping("/vintage")
    Object topVintage(@RequestParam int top){

        var years = wineService.findBestYear(PageRequest.of(0,top));
        Map<String, List<WineEntity>> map = new HashMap<>();
        for(String year : years){
            map.put(year, wineService.findByYear(year));

        }
        return map;

    }




    @GetMapping("/best")
    public List<WineEntity> getBestWines() {

        List<WineEntity> wines=
                wineService.findAllWines()
                        .stream()
                        .sorted(Collections.reverseOrder(Comparator.comparing(WineEntity::getRating))).limit(10)
                        .collect(Collectors.toList());

        return wines;
    }

    @GetMapping("/best/{top}")
    public List<WineEntity> getBestWinesTopX(@PathVariable("top") int top) {

        List<WineEntity> wines= wineService.findAllWines().stream().sorted(Collections.reverseOrder(Comparator.comparing(WineEntity::getRating))).limit(top).collect(Collectors.toList());

        return wines;
    }

    @GetMapping("/expensive")
    public List<WineEntity> getExpensiveWines() {

        List<WineEntity> wines= wineService.findAllWines().stream().sorted(Collections.reverseOrder(Comparator.comparing(WineEntity::getPrice))).limit(10).collect(Collectors.toList());

        return wines;
    }


    @GetMapping("/expensive/{top}")
    public List<WineEntity> getExpensiveWinesTopX(@PathVariable("top") int top) {
        List<WineEntity> wines= wineService.findAllWines().stream().sorted(Collections.reverseOrder(Comparator.comparing(WineEntity::getPrice))).limit(top).collect(Collectors.toList());

        return wines;
    }


}
