package com.detection.server.controller;

import com.detection.server.entity.SensorData1;
import com.detection.server.entity.SensorData2;
import com.detection.server.entity.SensorData3;
import com.detection.server.entity.SensorData4;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@RestController
public class HttpController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/1")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "/test";
    }

    @GetMapping("/SensorData1")
    List<SensorData1> getSensorData1(){
        Query query = new Query();
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        return mongoTemplate.find(query, SensorData1.class);
    }
    @GetMapping("/SensorData2")
    List<SensorData2> getSensorData2(){
        Query query = new Query();
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        return mongoTemplate.find(query, SensorData2.class);
    }

    @GetMapping("/SensorData3")
    List<SensorData3> getSensorData3(){
        Query query = new Query();
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        return mongoTemplate.find(query, SensorData3.class);
    }

    @GetMapping("/SensorData4")
    List<SensorData4> getSensorData4(){
        Query query = new Query();
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        return mongoTemplate.find(query, SensorData4.class);
    }

    @PostMapping("/SensorData1")
    SensorData1 postSensorData1(@RequestParam String name,
                                @RequestParam Integer value,
                                @RequestParam  Long timestamp){
        keepLastSensorData1();

        SensorData1 sensorData1 = new SensorData1();
        sensorData1.setName(name);
        sensorData1.setValue(value);
        sensorData1.setTime(new Date(timestamp));
        System.out.println("OK");
        System.out.println(sensorData1);
        return mongoTemplate.insert(sensorData1);
    }

    @PostMapping("/SensorData2")
    SensorData2 postSensorData2(@RequestParam String name,
                                @RequestParam Integer value,
                                @RequestParam Long timestamp){
        keepLastSensorData2();

        SensorData2 SensorData2 = new SensorData2();
        SensorData2.setName(name);
        SensorData2.setValue(value);
        SensorData2.setTime(new Date(timestamp));
        return mongoTemplate.insert(SensorData2);
    }

    @PostMapping("/SensorData3")
    SensorData3 postSensorData3(@RequestParam String name,
                                @RequestParam Integer value,
                                @RequestParam Long timestamp){
        keepLastSensorData3();

        SensorData3 SensorData3 = new SensorData3();
        SensorData3.setName(name);
        SensorData3.setValue(value);
        SensorData3.setTime(new Date(timestamp));
        return mongoTemplate.insert(SensorData3);
    }

    @PostMapping("/SensorData4")
    SensorData4 postSensorData4(@RequestParam String name,
                                @RequestParam Integer value,
                                @RequestParam Long timestamp){
        keepLastSensorData4();

        SensorData4 SensorData4 = new SensorData4();
        SensorData4.setName(name);
        SensorData4.setValue(value);
        SensorData4.setTime(new Date(timestamp));
        return mongoTemplate.insert(SensorData4);
    }

    void keepLastSensorData1(){
        Query query = new Query();
        query.skip(9);
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        DeleteResult remove = mongoTemplate.remove(query, SensorData1.class);
    }

    void keepLastSensorData2(){
        Query query = new Query();
        query.skip(9);
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        DeleteResult remove = mongoTemplate.remove(query, SensorData2.class);
    }

    void keepLastSensorData3(){
        Query query = new Query();
        query.skip(9);
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        DeleteResult remove = mongoTemplate.remove(query, SensorData3.class);
    }

    void keepLastSensorData4(){
        Query query = new Query();
        query.skip(9);
        query.with(Sort.by(
                Sort.Order.desc("time")
        ));
        DeleteResult remove = mongoTemplate.remove(query, SensorData4.class);
    }
}
