package com.wine.winecrud.repository;

import com.wine.winecrud.entity.WineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Integer> {


    @Query(value = "select * from wine order by price ASC , rating DESC ", nativeQuery = true)
    List<WineEntity> topRatingPrice();

    @Query(value = " select * from wine group by year order by rating DESC ", nativeQuery = true)
    List<WineEntity> bestVintage();
}
