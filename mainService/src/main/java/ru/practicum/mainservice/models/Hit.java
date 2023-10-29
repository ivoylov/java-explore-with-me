package ru.practicum.mainservice.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hits", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hit_id")
    Long id;
    @Column(name = "hit_app")
    String app;
    @Column(name = "hit_uri")
    String uri;
    @Column(name = "hit_ip")
    String ip;
    @Column(name = "hit_timestamp")
    LocalDateTime timestamp;
}
