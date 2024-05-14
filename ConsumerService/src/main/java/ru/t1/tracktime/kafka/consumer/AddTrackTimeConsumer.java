package ru.t1.tracktime.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.t1.tracktime.dto.NewTrackTimeDto;
import ru.t1.tracktime.service.TrackTimeService;

@Slf4j
@Component
@AllArgsConstructor
public class AddTrackTimeConsumer {
    private final TrackTimeService trackTimeService;
    private ObjectMapper objectMapper;


    /**
     * Kafka listener method to consume messages from the "metrics-topic" topic.
     * @param message The message containing NewTrackTimeDto.
     */
    @KafkaListener(topics = "metrics-topic", groupId = "track-time-group")
    public void consume(String message) {
        NewTrackTimeDto newTrackTimeDto = objectMapper.convertValue(message, NewTrackTimeDto.class);
        log.debug("KafkaConsumer add newTrackTime: {} from Producer service", newTrackTimeDto);
        trackTimeService.add(newTrackTimeDto);
    }

}
