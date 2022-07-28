package com.wine.winecrud.repository;

import com.wine.winecrud.entity.WineEntity;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Integer> {


    @Query(value = "select * from wine order by rating/price desc ", nativeQuery = true)
    List<WineEntity> topRatingPrice();

    @Query(value = " select * from wine group by year order by rating DESC ", nativeQuery = true)
    List<WineEntity> bestVintage();



    @Query(value = "select year from wine group by year order by avg(rating) desc", nativeQuery = true)
    List<String> findBestYears();

   List<WineEntity> findByYear(String year);



    @Query(value = " select year from wine group by year order by avg(rating) DESC, year", nativeQuery = true)
    List<String> findBestYear(Pageable pageable);

    @Query(value = " select w from WineEntity w where w.year = ?1 order by w.rating")
    List<WineEntity> findTopBestWine(Pageable pageable,String year);


}
