package com.wine.winecrud.repository;

import com.wine.winecrud.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<RegionEntity,Integer> {
}

