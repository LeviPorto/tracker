package com.levi.tracker.document.parent

import lombok.Data;

@Data
abstract class LocalizedEntity {

    private Double latitude;
    private Double longitude;

}
