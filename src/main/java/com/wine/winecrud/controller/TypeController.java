package com.wine.winecrud.controller;


import com.wine.winecrud.entity.TypeEntity;
import com.wine.winecrud.entity.TypeEntity;
import com.wine.winecrud.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeEntity>> typeList()
    {
        List<TypeEntity> typeEntities = typeService.getAll();

        if(typeEntities.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(typeEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEntity> getType(@PathVariable("id") int id)
    {
        TypeEntity typeEntity = typeService.getTypeById(id);
        if(typeEntity == null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(typeEntity);
    }

    @PostMapping
    public ResponseEntity<TypeEntity> saveType(@Valid @RequestBody TypeEntity typeEntity)
    {
        TypeEntity type = typeService.save(typeEntity);
        return ResponseEntity.ok(type);
    }

    @DeleteMapping
    public ResponseEntity<TypeEntity> deleteType(@RequestBody TypeEntity typeEntity)
    {
        TypeEntity type = typeService.delete(typeEntity);
        return ResponseEntity.ok(type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeEntity> deleteTypeById(@PathVariable("id") int id)
    {
        TypeEntity typeEntity = typeService.getTypeById(id);
        if(typeEntity != null)
        {
            typeService.deleteById(id);
        }
        return ResponseEntity.ok(typeEntity);
    }

    @PutMapping
    public ResponseEntity<TypeEntity> updateType(@RequestBody TypeEntity typeEntity)
    {
        TypeEntity type = typeService.update(typeEntity);
        return ResponseEntity.ok(type);
    }

}
