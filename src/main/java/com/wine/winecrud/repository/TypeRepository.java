package com.wine.winecrud.repository;

import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
}
