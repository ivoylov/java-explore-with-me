package ru.practicum.mainservice.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.mainservice.Create;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoIn {
    @NotBlank(groups = Create.class)
    String name;
    @Email(groups = Create.class)
    String email;
}
