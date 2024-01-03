package com.detection.server.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("Devices")
public class Device {
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
    private String Size;

    /**
     *
     */
    private String manufacturer;

    /**
     *
     */
    private String information;

    /**
     *
     */
    private String category;

    /**
     *
     */
    private Integer lifetime;
}
