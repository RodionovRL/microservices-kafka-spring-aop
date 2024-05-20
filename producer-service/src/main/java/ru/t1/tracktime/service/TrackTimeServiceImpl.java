package ru.t1.tracktime.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.t1.tracktime.kafka.produser.TrackTimeProducer;
import ru.t1.tracktime.dto.NewTrackTimeDto;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackTimeServiceImpl implements TrackTimeService {
    private final TrackTimeProducer trackTimeProducer;

    @Async
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(String name, Boolean isAsync, LocalDateTime timeStamp, Long executionDuration) {
        NewTrackTimeDto newTrackTimeDto = NewTrackTimeDto.builder()
                .name(name)
                .isAsync(isAsync)
                .timeStamp(timeStamp)
                .executionDuration(executionDuration)
                .build();

        log.info("TrackTime: add newTrackTimeDto={}", newTrackTimeDto);

        trackTimeProducer.sendMessage(newTrackTimeDto);

        log.info("TrackTime: send newTrackTimeDto={}", newTrackTimeDto);
    }
}
