package ru.practicum.mainservice.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.practicum.mainservice.category.dto.CategoryDto;
import ru.practicum.mainservice.user.dto.UserShortDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventShortDto {

    private Long id;
    @NotEmpty
    private String annotation;
    private Long confirmedRequests;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;
    private Boolean paid;
    @NotEmpty
    private String title;
    private Long views;
    @NotNull
    private CategoryDto category;
    @NotNull
    private UserShortDto initiator;

}
