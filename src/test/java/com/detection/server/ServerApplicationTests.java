package com.detection.server;

import com.detection.server.entity.SensorData1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class ServerApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        SensorData1 sensorData1 = new SensorData1();
        sensorData1.setName("sensor1");
        sensorData1.setValue(20);
        Date time = new Date();
        sensorData1.setTime(time);
        SensorData1 sensorData11 = mongoTemplate.insert(sensorData1);
        System.out.println(sensorData11);
    }

    @Test
    void test(){
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
