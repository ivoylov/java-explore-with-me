package ru.practicum.mainservice.models.event;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "title")
    String title;
    @Column(name = "annotation")
    String annotation;
    @Column(name = "description")
    String description;
    @Column(name = "event_date")
    LocalDateTime eventDate;
    @Column(name = "participant_limit")
    Integer participantLimit;
    @Column(name = "paid")
    Boolean paid;
    @Column(name = "lat")
    Double lat;
    @Column(name = "lon")
    Double lon;
    @Column(name = "request_moderation")
    Boolean requestModeration;
}
