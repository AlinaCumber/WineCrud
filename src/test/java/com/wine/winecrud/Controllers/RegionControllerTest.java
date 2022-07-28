package com.wine.winecrud.Controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;

import com.wine.winecrud.controller.RegionController;
import com.wine.winecrud.entity.RegionEntity;
import com.wine.winecrud.service.RegionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;


import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(RegionController.class)
class RegionControllerTest {

    @MockBean
    private RegionService regionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", password = "password", roles = {"USER"})
    void getAllRegionsTest() throws Exception {
        RegionEntity region1 = new RegionEntity("Alicante", "Spain");
        RegionEntity region2 = new RegionEntity("Rioja", "Spain");

        Mockito.when(regionService.getAll()).thenReturn(Arrays.asList(region1, region2));

        mockMvc.perform(MockMvcRequestBuilders.get("/region"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Rioja"));

    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = {"USER"})
    void getRegionTest() throws Exception {
        RegionEntity region1 = new RegionEntity("Valencia", "Spain");

        Mockito.when(regionService.getRegionById(1)).thenReturn(region1);

        mockMvc.perform(MockMvcRequestBuilders.get("/region/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Valencia"));

    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = {"USER"})
    void saveRegionTest() throws Exception {
        RegionEntity region1 = new RegionEntity("Valencia", "Spain");

        Mockito.when(regionService.save(Mockito.any(RegionEntity.class))).thenReturn(region1);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(region1);

        mockMvc.perform(MockMvcRequestBuilders.post("/region/")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json;"));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = {"USER"})
    void updateRegionTest() throws Exception {
        RegionEntity region1 = new RegionEntity("Valencia", "Spain");

        Mockito.when(regionService.update(Mockito.any(RegionEntity.class))).thenReturn(region1);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(region1);

        mockMvc.perform(MockMvcRequestBuilders.put("/region/")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json;"));
    }

}