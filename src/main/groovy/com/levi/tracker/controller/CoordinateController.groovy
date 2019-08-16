package com.levi.tracker.controller;

import com.levi.tracker.document.Coordinate;
import com.levi.tracker.service.CoordinateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracker/coordinate")
class CoordinateController {

    private final CoordinateService service;

    CoordinateController(final CoordinateService service){
        this.service = service;
    }

    @PostMapping
    Coordinate create(@RequestBody Coordinate coordinate) {
        return service.create(coordinate);
    }

    @PostMapping
    List<Coordinate> create(@RequestBody List<Coordinate> coordinates) {
        return service.create(coordinates);
    }

    @GetMapping("/orderPath")
    List<Coordinate> getOrderPath(@RequestParam Integer deviceId, @RequestParam("orderId") Integer orderId) {
        return service.retrieveOrderPath(deviceId, orderId);
    }

}
