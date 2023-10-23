package ru.practicum.statisticservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.statisticservice.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Hit, Long> {
    @Query(value = "SELECT * " +
            "FROM hits " +
            "WHERE (hit_timestamp between :start and :end) " +
            "and (hit_uri in :uris)",
            nativeQuery = true)
    List<Hit> find(LocalDateTime start, LocalDateTime end, String[] uris);

}