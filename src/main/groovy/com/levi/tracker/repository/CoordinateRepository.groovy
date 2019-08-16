package com.levi.tracker.repository;

import com.levi.tracker.document.Coordinate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
interface CoordinateRepository extends MongoRepository<Coordinate, String> {

    List<Coordinate> findByDateBetweenAndDeviceId(Instant beginDate, Instant endDate, Integer deviceId);

    List<Coordinate> findByDateGreaterThanEqualAndDeviceId(Instant date, Integer deviceId);

}
