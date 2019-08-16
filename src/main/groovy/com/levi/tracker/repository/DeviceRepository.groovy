package com.levi.tracker.repository;

import com.levi.tracker.document.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DeviceRepository extends MongoRepository<Device, String> {

}
