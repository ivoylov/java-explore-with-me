package ru.practicum.mainservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hits", schema = "public")
@FieldDefaults
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
