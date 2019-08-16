package com.levi.tracker.publisher;

import com.levi.tracker.document.Coordinate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

//TODO ver se eh importante mandar todos os dados de coordenadas pro kafka

@Component
class CoordinatePublisher {

    private final KafkaTemplate<String, Coordinate> kafkaTemplate;

    @Value("${spring.kafka.topic.coordinate}")
    public String topicCoordinate;

    CoordinatePublisher(final KafkaTemplate<String, Coordinate> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    Coordinate sendCoordinateToTopic(Coordinate coordinate) {
        Message<Coordinate> message = MessageBuilder
                .withPayload(coordinate)
                .setHeader(KafkaHeaders.TOPIC, topicCoordinate)
                .build();
        kafkaTemplate.send(message);
        return coordinate;
    }

}
