package com.wine.winecrud.Controllers;

import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.service.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class RegionControllersTests {

    @Autowired
    private RegionService regionService;
    RegionEntity regionEntity = new RegionEntity();

    @Test
    public void InsertRegion_inserts()
    {
        regionEntity.setName("nameTest1");
        regionEntity.setCountry("countryTest1");
        RegionEntity regionEntityInserted = regionService.save(regionEntity);

        RegionEntity regionEntityFound = regionService.getRegionById(regionEntityInserted.getId());

        Assert.notNull(regionEntityFound);
    }

    @Test
    public void DeleteRegion_deletes()
    {
        regionEntity.setName("DeleteRegionName");
        regionEntity.setCountry("DeleteRegionCountry");
        RegionEntity regionEntityInserted = regionService.save(regionEntity);

        regionService.delete(regionEntity);

        RegionEntity regionEntityFound = regionService.getRegionById(regionEntityInserted.getId());

        Assert.isNull(regionEntityFound);
    }

    @Test
    public void UpdateRegion_Updates()
    {

        regionEntity.setName("PrevUpdateRegionName");
        regionEntity.setCountry("PrevUpdateRegionCountry");
        RegionEntity regionEntityInserted = regionService.save(regionEntity);

        regionEntityInserted.setName("PostUpdateRegionName");
        regionEntityInserted.setCountry("PostUpdateRegionCountry");

        RegionEntity UpdatedRegionEntityFound = regionService.update(regionEntityInserted);


        Assert.isTrue(UpdatedRegionEntityFound.getName().equals("PostUpdateRegionName"));

    }

}
