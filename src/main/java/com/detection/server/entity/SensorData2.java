package com.detection.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("SensorData2")
public class SensorData2 {
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
