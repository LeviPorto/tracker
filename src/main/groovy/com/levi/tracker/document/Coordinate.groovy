package com.levi.tracker.document;

import com.levi.tracker.document.parent.LocalizedEntity
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.Instant;

@Document
@Data
class Coordinate extends LocalizedEntity {

    private Instant date;
    private Integer deviceId;
    private Double speed;
    @Id private String id;

}
