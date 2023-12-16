package ru.practicum.mainservice.models.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.models.user.User;

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

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "initiator", nullable = false)
    User initiator;

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

    public String toString() {
        return String.format("id=%d, description=%s",
                id, description);
    }

}
