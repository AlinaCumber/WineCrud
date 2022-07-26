package com.wine.winecrud.Controllers;

import com.wine.winecrud.entity.WineryEntity;
import com.wine.winecrud.service.WineryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class WineryControllersTests {

    @Autowired
    private WineryService wineryService;
    WineryEntity wineryEntity = new WineryEntity();

    @Test
    public void InsertWinery_inserts()
    {

        wineryEntity.setName("nameTest1");
        WineryEntity wineryEntityInserted = wineryService.save(wineryEntity);

        WineryEntity wineryEntityFound = wineryService.getWineryById(wineryEntityInserted.getId());

        Assert.notNull(wineryEntityFound);

    }

    @Test
    public void DeleteWinery_deletes()
    {

        wineryEntity.setName("DeleteWineryName");
        WineryEntity wineryEntityInserted = wineryService.save(wineryEntity);

        wineryService.delete(wineryEntity);

        WineryEntity wineryEntityFound = wineryService.getWineryById(wineryEntityInserted.getId());

        Assert.isNull(wineryEntityFound);

    }
    
    @Test
    public void UpdateWinery_Updates()
    {

        wineryEntity.setName("PrevUpdateWineryName");
        WineryEntity wineryEntityInserted = wineryService.save(wineryEntity);

        wineryEntityInserted.setName("PostUpdateWineryName");

        WineryEntity UpdatedWineryEntityFound = wineryService.update(wineryEntityInserted);


        Assert.isTrue(UpdatedWineryEntityFound.getName().equals("PostUpdateWineryName"));

    }

}
