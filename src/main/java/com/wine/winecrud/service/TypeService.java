package com.wine.winecrud.service;


import com.wine.winecrud.entity.TypeEntity;
import com.wine.winecrud.entity.WineryEntity;
import com.wine.winecrud.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<TypeEntity> getAll()
    {
        return typeRepository.findAll();
    }
    public TypeEntity getTypeById(int id)
    {
        return typeRepository.findById(id).orElse(null);
    }

    public TypeEntity save(TypeEntity typeNew)
    {
        return typeRepository.save(typeNew);
    }

    public TypeEntity update(TypeEntity typeNew)
    {
        return typeRepository.save(typeNew);
    }
    public TypeEntity delete(TypeEntity typeDelete)
    {
        typeRepository.delete(typeDelete);
        return typeDelete;
    }

    public void deleteById(int Id)
    {
        typeRepository.deleteById(Id);

    }

}
