package com.detection.server;

import com.detection.server.entity.Device;
import com.detection.server.entity.SensorData1;
import com.detection.server.entity.SensorData4;
import com.detection.server.entity.UserInfo;
import com.mongodb.client.result.DeleteResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
    void findAllUser(){
        List<UserInfo> userInfos = mongoTemplate.findAll(UserInfo.class);
        System.out.println(userInfos);
    }

    @Test
    void addAnotherUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("admin1");
        userInfo.setPassword("admin1");
        UserInfo userInfo1 = mongoTemplate.insert(userInfo);
        System.out.println(userInfo1);
    }

    @Test
    void deleteUser(){
        Query query = new Query();
        DeleteResult remove = mongoTemplate.remove(query, UserInfo.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setName("admin");
        userInfo.setPassword("admin");
        UserInfo userInfo1 = mongoTemplate.insert(userInfo);
        System.out.println(userInfo1);
    }

    @Test
    void addDevices(){
        Query query = new Query();
        DeleteResult remove = mongoTemplate.remove(query, Device.class);

        Device device1 = new Device();
        device1.setName("光照传感器");
        device1.setSize("小型设备");
        device1.setManufacturer("可达公司");
        device1.setInformation("这是一个光照传感器");
        device1.setCategory("光照");
        device1.setLifetime(12);

        Device device2 = new Device();
        device2.setName("湿度传感器");
        device2.setSize("小型设备");
        device2.setManufacturer("可达公司");
        device2.setInformation("这是一个湿度传感器");
        device2.setCategory("湿度");
        device2.setLifetime(9);

        Device device3 = new Device();
        device3.setName("温度传感器");
        device3.setSize("小型设备");
        device3.setManufacturer("可达公司");
        device3.setInformation("这是一个温度传感器");
        device3.setCategory("温度");
        device3.setLifetime(6);

        Device device4 = new Device();
        device4.setName("PM2.5传感器");
        device4.setSize("小型设备");
        device4.setManufacturer("可达公司");
        device4.setInformation("这是一个PM2.5传感器");
        device4.setCategory("PM2.5");
        device4.setLifetime(15);

        mongoTemplate.insert(device1);
        mongoTemplate.insert(device2);
        mongoTemplate.insert(device3);
        mongoTemplate.insert(device4);
    }

    @Test
    void findAllDevices(){
        List<Device> devices = mongoTemplate.findAll(Device.class);
        System.out.println(devices);
    }

    @Test
    void test(){
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
