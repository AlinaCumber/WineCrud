package com.wine.winecrud.service;


import com.wine.winecrud.entity.TypeEntity;
import com.wine.winecrud.entity.WineryEntity;
import com.wine.winecrud.repository.WineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryService {
    @Autowired
    private WineryRepository wineryRepository;

    public List<WineryEntity> getAll()
    {
        return wineryRepository.findAll();
    }
    public WineryEntity getWineryById(int id)
    {
        return wineryRepository.findById(id).orElse(null);
    }

    public WineryEntity save(WineryEntity wineryNew)
    {
        return wineryRepository.save(wineryNew);
    }

    public WineryEntity update(WineryEntity typeUpdate)
    {
        return wineryRepository.save(typeUpdate);
    }

    public WineryEntity delete(WineryEntity wineryDelete)
    {
         wineryRepository.delete(wineryDelete);
         return wineryDelete;
    }
    public void deleteById(int Id)
    {
        wineryRepository.deleteById(Id);

    }


}
