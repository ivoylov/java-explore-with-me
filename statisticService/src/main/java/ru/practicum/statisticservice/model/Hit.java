package ru.practicum.statisticservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hits", schema = "public")
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hit_id")
    private Long id;
    @Column(name = "hit_app")
    private String app;
    @Column(name = "hit_uri")
    private String uri;
    @Column(name = "hit_ip")
    private String ip;
    @Column(name = "hit_timestamp")
    private String timestamp;
}
