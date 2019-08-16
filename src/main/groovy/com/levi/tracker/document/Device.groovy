package com.levi.tracker.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
class Device {

    @Id private String id;
    private Integer IMEI;
    private Integer deliverymanId;

}
