package ru.t1.tracktime.service;

import java.time.LocalDateTime;

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
