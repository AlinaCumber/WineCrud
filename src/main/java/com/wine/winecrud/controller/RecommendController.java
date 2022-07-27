package com.wine.winecrud.controller;

import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping("/vintage")
    public ResponseEntity<List<WineEntity>> getVintage(@RequestParam int top){
        List<WineEntity> wines = wineService.topVintage();

        Stream<WineEntity> w = wines.stream().limit(top);

        return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
    }
}
