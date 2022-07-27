package com.wine.winecrud.controller;


import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private WineService wineService;

    @GetMapping("/best")
    public List<WineEntity> getBestWines() {

        List<WineEntity> wines= wineService.findAllWines().stream().sorted(Collections.reverseOrder(Comparator.comparing(WineEntity::getRating))).limit(10).collect(Collectors.toList());

        return wines;
    }


}
