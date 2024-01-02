package com.detection.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Document("SensorData1")
public class SensorData1 {
    /**
     *
     */
    @Id
    private String id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Date time;

    /**
     *
     */
    private Integer value;
}
