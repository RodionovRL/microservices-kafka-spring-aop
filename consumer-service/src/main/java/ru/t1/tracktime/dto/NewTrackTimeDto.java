package ru.t1.tracktime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewTrackTimeDto {
    private String name;
    private Boolean isAsync;
    private LocalDateTime timeStamp;
    private Long executionDuration;
}
