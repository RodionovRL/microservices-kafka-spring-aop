package ru.t1.tracktime.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TrackTime {
    private Long id;
    private String name;
    private Boolean isAsync;
    private LocalDateTime timeStamp;
    private Long executionDuration;
}
