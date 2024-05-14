package ru.t1.owner.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

//@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewOwnerDto {
    @Size(min = 2, max = 30, message = "validation name size error")
    @Pattern(regexp = "^(?=.*[a-zA-Zа-яёЁА-Я\\d_\\S]).+$")
    private String name;
    @Email(message = "Field: email. Error: must be email format.")
    @NotBlank(message = "Field: email. Error: must not be blank.")
    @Size(min = 6, max = 254, message = "validation email size error")
    private String email;
}
