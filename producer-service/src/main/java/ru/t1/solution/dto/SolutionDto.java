package ru.t1.solution.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
