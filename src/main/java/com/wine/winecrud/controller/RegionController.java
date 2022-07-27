package com.wine.winecrud.controller;


import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.entity.WineryEntity;
import com.wine.winecrud.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionEntity>> regionList()
    {
        List<RegionEntity> regionEntities = regionService.getAll();

        if(regionEntities.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionEntity> getRegion(@PathVariable("id") int id)
    {
        RegionEntity regionEntity = regionService.getRegionById(id);
        if(regionEntity == null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionEntity);
    }

    @PostMapping
    public ResponseEntity<RegionEntity> saveRegion(@Valid @RequestBody RegionEntity regionEntity)
    {
        RegionEntity region = regionService.save(regionEntity);
        return ResponseEntity.ok(region);
    }

    @DeleteMapping
    public ResponseEntity<RegionEntity> deleteType(@RequestBody RegionEntity regionEntity)
    {
        RegionEntity region = regionService.delete(regionEntity);
        return ResponseEntity.ok(region);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegionEntity> deleteTypeById(@PathVariable("id") int id)
    {
        RegionEntity regionEntity = regionService.getRegionById(id);
        if(regionEntity != null)
        {
            regionService.deleteById(id);
        }
        return ResponseEntity.ok(regionEntity);
    }

    @PutMapping
    public ResponseEntity<RegionEntity> updateType(@RequestBody RegionEntity serviceEntity)
    {
        RegionEntity service = regionService.update(serviceEntity);
        return ResponseEntity.ok(service);
    }

}
