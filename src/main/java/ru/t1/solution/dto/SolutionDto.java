package ru.t1.solution.dto;

import lombok.*;
import ru.t1.owner.model.Owner;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SolutionDto {
    private Long id;
    private String name;
    private String version;
    private Owner owner;
}
