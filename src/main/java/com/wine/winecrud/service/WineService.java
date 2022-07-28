package com.wine.winecrud.service;

import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    WineRepository wineRepository;

    public List<WineEntity> findAllWines(){
        return wineRepository.findAll();
    }

    public WineEntity saveWine(WineEntity wine){
        return wineRepository.save(wine);
    }

    public WineEntity findById(int id){
        return wineRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        wineRepository.deleteById(id);
    }

    public WineEntity updateWine(WineEntity wine){
         return wineRepository.save(wine);
    }

    public List<WineEntity> topRatingPrice (){
        return wineRepository.topRatingPrice();
    }

    public List<WineEntity> topVintage(){
        return wineRepository.bestVintage();
    }

    public List<WineEntity> topWines(){
        return wineRepository.topWines();
    }

    public List<WineEntity> topExpensiveWines(){
        return wineRepository.topExpensiveWines();
    }

   /*public List<Object[]> findBestYear(Pageable pageable){
        return wineRepository.findBestYear(pageable);
    }

    public List<WineEntity> findTop10Rating(String year, Pageable pageable) {
        return wineRepository.findTop10Rating(year, pageable);*/


    /*public List<String> findWineBestYear(int numItems){
        return wineRepository.findBestYears().subList(0, numItems);
    }

    public List<WineEntity> findByYear(String year){
        return wineRepository.findByYear(year);
    }*/



}
