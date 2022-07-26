package com.wine.winecrud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wine.winecrud.entity.WineEntity;
import com.wine.winecrud.repository.WineRepository;
import com.wine.winecrud.service.WineService;
import net.minidev.json.JSONUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class WineControllerTest {



    @Autowired
    private WineService wineService;








    @Test
    void saveWine() throws Exception {
        WineEntity customer = new WineEntity();
        customer.setName("Test");
        WineEntity winerInsert = wineService.saveWine(customer);
        WineEntity wineFound = wineService.findById(winerInsert.getId());
        Assert.notNull(wineFound);
    }





    @Test
    void updateWine() {
        WineEntity customer = new WineEntity();
        customer.setName("Test");
        WineEntity winerInsert = wineService.saveWine(customer);

        winerInsert.setName("Carlos");
        WineEntity wineFound = wineService.updateWine(winerInsert);
        Assert.isTrue(wineFound.getName().equals("Carlos"));
    }

    @Test
    void listWines() throws Exception {

    }



    @Test
    void wineById() {
    }



    @Test
    void deleteWine() {
        WineEntity customer = new WineEntity();
        customer.setId(1);

        WineEntity winerInsert = wineService.saveWine(customer);

        wineService.deleteById(winerInsert.getId());

        WineEntity wineFound = wineService.findById(winerInsert.getId());

        Assert.isNull(wineFound);
    }
}