package com.wine.winecrud.controller;

import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wine")
public class WineController {

    @Autowired
    WineService wineService;

    @GetMapping
    public ResponseEntity<List<WineEntity> >listWines(){
        List<WineEntity> wine = wineService.findAllWines();
        if(wine.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(wine);
    }

    @PostMapping
    public ResponseEntity<WineEntity> saveWine(@Valid @RequestBody WineEntity wine) {
        WineEntity newWine = wineService.saveWine(wine);
        return ResponseEntity.ok(newWine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineEntity> wineById(@PathVariable("id") int id){
        WineEntity newWine =  wineService.findById(id);
        if(newWine == null){

        }
        return ResponseEntity.ok(newWine);
    }

    @PutMapping
    public ResponseEntity<WineEntity> updateWine(@RequestBody WineEntity wine) {
        WineEntity newWine = wineService.updateWine(wine);
        return ResponseEntity.ok(newWine);
    }

    @DeleteMapping("/{id}")
        public void deleteWine(@PathVariable("id") int id){
        wineService.deleteById(id);
    }

}
