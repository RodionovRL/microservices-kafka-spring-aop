package ru.t1.tracktime.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.t1.tracktime.dto.NewTrackTimeDto;
import ru.t1.tracktime.dto.TrackTimeAverageDto;
import ru.t1.tracktime.dto.TrackTimeDto;
import ru.t1.tracktime.dto.TrackTimeStatDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TrackTimeService {
    /**
     * Добавление новой записи о времени выполнения метода
     *
     * @param name      имя метода
     * @param isAsync   синхронный или асинхронный
     * @param timeStamp штамп времени выполнения
     * @param executionDuration время, затраченное методом
     */
    void add(String name, Boolean isAsync, LocalDateTime timeStamp, Long executionDuration);

}
