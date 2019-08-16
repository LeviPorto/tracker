package com.levi.tracker.service;

import com.levi.tracker.document.Coordinate;
import com.levi.tracker.dto.OrderDTO;
import com.levi.tracker.publisher.CoordinatePublisher
import com.levi.tracker.repository.CoordinateRepository;
import org.springframework.stereotype.Service;

//TODO Se atentar a não colocar coordinatePublisher, mas soh publisher (outras entidades)

@Service
class CoordinateService {

    private final CoordinateRepository repository;
    private final CoordinatePublisher publisher;

    CoordinateService(final CoordinateRepository repository, final CoordinatePublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    Coordinate create(Coordinate coordinate) {
        Coordinate createdCoordinate = repository.save(coordinate);
        return publisher.sendCoordinateToTopic(createdCoordinate);
    }

    List<Coordinate> create(List<Coordinate> coordinates) {
        List<Coordinate> createdCoordinates = repository.saveAll(coordinates);
        createdCoordinates.forEach(publisher.&sendCoordinateToTopic);
        return createdCoordinates;
    }

    List<Coordinate> retrieveOrderPath(Integer deviceId, Integer orderId) {
        // pega o order usando http-client
        OrderDTO orderDTO = new OrderDTO(); //como se fosse o pego
        if(orderDTO.getDeliveryDate() == null) {
            return repository.findByDateGreaterThanEqualAndDeviceId(orderDTO.getCreatedDate(), orderId);
        } else {
            return repository.findByDateBetweenAndDeviceId(orderDTO.getCreatedDate(), orderDTO.getDeliveryDate(), deviceId);
        }
    }

}
