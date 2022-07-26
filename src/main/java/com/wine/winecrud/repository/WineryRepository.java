package com.wine.winecrud.repository;

import com.wine.winecrud.entity.WineryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineryRepository extends JpaRepository<WineryEntity, Integer> {
}
