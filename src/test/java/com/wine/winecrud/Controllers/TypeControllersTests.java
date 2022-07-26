package com.wine.winecrud.Controllers;

import com.wine.winecrud.entity.TypeEntity;
import com.wine.winecrud.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class TypeControllersTests {

    @Autowired
    private TypeService typeService;
    TypeEntity typeEntity = new TypeEntity();

    @Test
    public void InsertType_inserts()
    {

        typeEntity.setName("nameTest1");
        TypeEntity typeEntityInserted = typeService.save(typeEntity);

        TypeEntity typeEntityFound = typeService.getTypeById(typeEntityInserted.getId());

        Assert.notNull(typeEntityFound);

    }

    @Test
    public void DeleteType_deletes()
    {

        typeEntity.setName("DeleteTypeName");
        TypeEntity typeEntityInserted = typeService.save(typeEntity);

        typeService.delete(typeEntity);

        TypeEntity typeEntityFound = typeService.getTypeById(typeEntityInserted.getId());

        Assert.isNull(typeEntityFound);

    }
    
    @Test
    public void UpdateType_Updates()
    {

        typeEntity.setName("PrevUpdateTypeName");
        TypeEntity typeEntityInserted = typeService.save(typeEntity);

        typeEntityInserted.setName("PostUpdateTypeName");

        TypeEntity UpdatedTypeEntityFound = typeService.update(typeEntityInserted);


        Assert.isTrue(UpdatedTypeEntityFound.getName().equals("PostUpdateTypeName"));

    }

}
