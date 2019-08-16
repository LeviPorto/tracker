package com.levi.tracker.service;

import com.levi.tracker.document.Device;
import com.levi.tracker.repository.DeviceRepository;
import org.springframework.stereotype.Service;

//TODO Se atentar a não colocar coordinatePublisher, mas soh publisher (outras entidades)

@Service
class DeviceService {

    private final DeviceRepository repository;

    DeviceService(final DeviceRepository repository) {
        this.repository = repository;
    }

    Device create(Device device) {
        return repository.save(device);
    }

}
