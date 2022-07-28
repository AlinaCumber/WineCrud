package com.wine.winecrud.controller;


import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.repository.WineRepository;
import com.wine.winecrud.service.WineService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/recommend")
public class RecommendController {

    @Autowired
    WineService wineService;




    @GetMapping("/bang")
    public ResponseEntity<List<WineEntity>> getBestRatedWines(@RequestParam int top) {
        List<WineEntity> wines = wineService.topRatingPrice();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/vintage")
    Object topVintage(@RequestParam int top) {

        var years = wineService.findBestYear(PageRequest.of(0, top));
        Map<String, List<WineEntity>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, wineService.findTopYears(year));

        }
        return map;

    }







    @GetMapping("/best")
    public ResponseEntity<List<WineEntity>> getBestWinesTopX(@RequestParam int top) {
        List<WineEntity> wines = wineService.topWines();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }



    @GetMapping("/expensive")
    public ResponseEntity<List<WineEntity>> getExpensiveWinesTopX(@RequestParam int top) {
        List<WineEntity> wines = wineService.topExpensiveWines();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }





}
