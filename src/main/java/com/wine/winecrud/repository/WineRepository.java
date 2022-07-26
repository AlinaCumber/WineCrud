package com.wine.winecrud.repository;

import com.wine.winecrud.entity.WineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Integer> {
}
