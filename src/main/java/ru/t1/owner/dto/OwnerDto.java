package ru.t1.owner.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OwnerDto {
    private Long id;
    private String name;
    private String email;
}
