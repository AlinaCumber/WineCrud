package com.wine.winecrud.service;


import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<RegionEntity> getAll()
    {
        return regionRepository.findAll();
    }
    public RegionEntity getRegionById(int id)
    {
        return regionRepository.findById(id).orElse(null);
    }

    public RegionEntity save(RegionEntity regionNew)
    {

        return regionRepository.save(regionNew);
    }
}
