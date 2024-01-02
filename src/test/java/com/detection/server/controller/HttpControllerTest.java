package com.detection.server.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class HttpControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSenSorData1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/SensorData1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void postSensorData1() throws Exception {
        Date time = new Date();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/SensorData1")
                        .param("name", "sensor1")
                        .param("value", "12")
                        .param("time", time.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void postManySensorData1() throws Exception {
        for(int i = 16; i >= 0; i--){
            Date time = new Date();
            this.mockMvc.perform(MockMvcRequestBuilders.post("/SensorData1")
                    .param("name", "sensor1")
                    .param("value", ""+i)
                    .param("time", time.toString())
                    .contentType(MediaType.APPLICATION_JSON_VALUE));
        }
    }
}