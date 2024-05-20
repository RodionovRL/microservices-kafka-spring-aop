package ru.t1.tracktime.kafka.produser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.t1.tracktime.dto.NewTrackTimeDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackTimeProducer {

    /**
     * KafkaTemplate for sending messages to Kafka.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    /**
     * Sends a message with user json data to the "metrics-topic" Kafka topic.
     * @param newTrackTimeDto The newTrackTime DTO for send.
     */
    public void sendMessage(NewTrackTimeDto newTrackTimeDto) {
        String trackTimeJson;
        try {
            trackTimeJson = objectMapper.writeValueAsString(newTrackTimeDto);
        } catch (JsonProcessingException e) {
            log.error("Failed to create json from newTrackTimeDto {}", newTrackTimeDto, e);
            throw new RuntimeException("Failed to create json from newTrackTimeDto");
        }
        kafkaTemplate.send("metrics-topic", trackTimeJson);
        log.debug("Sent response to Kafka with newTrackTimeDto data." +
                "Topic: metrics-topic , newTrackTimeDto: {}", trackTimeJson);
    }
}
