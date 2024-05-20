package ru.t1.tracktime.service;

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

    /**
     * Добавление новой записи о времени выполнения метода
     *
     * @param newTrackTimeDto DTO содержащий данные для формирования записи времени выполнения метода
     */

    void add(NewTrackTimeDto newTrackTimeDto);

    /**
     * Получение всех записей о времени выполнения методов
     *
     * @return список всех записей о времени выполнения методов
     */
    List<TrackTimeDto> getAll();

    /**
     * Получение по имени всех записей о времени выполнения метода
     *
     * @param name имя метода
     * @return список всех записей о времени выполнения метода
     */
    List<TrackTimeDto> getAllByName(String name);

    /**
     * Получение по имени среднего времени выполнения метода
     *
     * @param name имя метода
     * @return DTO содержащее среднее время выполнения метода
     */
    TrackTimeAverageDto getAverageTrackTimeByName(String name);

    /**
     * Получение по имени статистики выполнения метода
     *
     * @param name имя метода
     * @return DTO содержащее статистику времени выполнения метода:
     * имя метода
     * число вызовов метода
     * среднее время выполнения метода
     * минимальное время выполнения метода
     * максимальное время выполнения метода
     */
    TrackTimeStatDto getStatByName(String name);
}
