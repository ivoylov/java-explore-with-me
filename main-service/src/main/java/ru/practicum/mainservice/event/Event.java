package ru.practicum.mainservice.event;

import lombok.*;
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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String annotation;
    private String description;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "event_date")
    private LocalDateTime eventDate;
    @Column(name = "published_on")
    private LocalDateTime publishedOn;
    private Boolean paid;
    @Column(name = "participant_limit")
    private Integer participantLimit;
    @Column(name = "confirmed_requests")
    private Long confirmedRequests;
    @Column(name = "request_moderation")
    private Boolean requestModeration;
    @Enumerated(EnumType.STRING)
    private EventState state;
    @Column(name = "location_lat")
    private Double lat;
    @Column(name = "location_lon")
    private Double lon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "events")
    private Set<Compilation> compilations = new HashSet<>();
}
