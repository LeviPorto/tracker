package com.levi.tracker.controller;

import com.levi.tracker.document.Device;
import com.levi.tracker.service.DeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracker/device")
class DeviceController {

    private final DeviceService service;

    DeviceController(final DeviceService service){
        this.service = service;
    }

    @PostMapping
    Device create(@RequestBody Device device) {
        return service.create(device);
    }

}
