package ru.practicum.mainservice.location;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.user.User;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "location_lat")
    Double lat;
    @Column(name = "location_lon")
    Double lon;
    String name;
    long radius;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    User owner;
    @Enumerated(EnumType.STRING)
    LocationStatus status;
}
