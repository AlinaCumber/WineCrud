package com.wine.winecrud.controller;


import com.wine.winecrud.entity.WineryEntity;
import com.wine.winecrud.service.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winery")
public class WineryController {

    @Autowired
    private WineryService wineryService;

    @GetMapping
    public ResponseEntity<List<WineryEntity>> wineryList()
    {
        List<WineryEntity> wineryEntities = wineryService.getAll();

        if(wineryEntities.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(wineryEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineryEntity> getWinery(@PathVariable("id") int id)
    {
        WineryEntity wineryEntity = wineryService.getWineryById(id);
        if(wineryEntity == null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(wineryEntity);
    }

    @PostMapping
    public ResponseEntity<WineryEntity> saveWinery(@RequestBody WineryEntity wineryEntity)
    {
        WineryEntity winery = wineryService.save(wineryEntity);
        return ResponseEntity.ok(winery);
    }

}
