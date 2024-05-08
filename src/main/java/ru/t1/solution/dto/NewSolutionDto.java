package ru.t1.solution.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewSolutionDto {
    @Size(min = 2, max = 30, message = "validation name size error")
    @Pattern(regexp = "^(?=.*[a-zA-Zа-яёЁА-Я\\d_\\S]).+$")
    @NotBlank
    private String name;
    @Builder.Default
    private String version = "0.0.1";
    @Positive
    private Long ownerId;
}