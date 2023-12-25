package ru.practicum.mainservice.event;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.category.Category;
import ru.practicum.mainservice.compilation.Compilation;
import ru.practicum.mainservice.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String annotation;
    String description;
    @Column(name = "created_on")
    LocalDateTime createdOn;
    @Column(name = "event_date")
    LocalDateTime eventDate;
    @Column(name = "published_on")
    LocalDateTime publishedOn;
    Boolean paid;
    @Column(name = "participant_limit")
    Integer participantLimit;
    @Column(name = "confirmed_requests")
    Long confirmedRequests;
    @Column(name = "request_moderation")
    Boolean requestModeration;
    @Enumerated(EnumType.STRING)
    EventState state;
    @Column(name = "location_lat")
    Double lat;
    @Column(name = "location_lon")
    Double lon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "events")
    Set<Compilation> compilations = new HashSet<>();
}
