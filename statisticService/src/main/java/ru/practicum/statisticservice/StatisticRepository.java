package ru.practicum.statisticservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.statisticservice.model.Hit;

@Repository
public interface StatisticRepository extends JpaRepository<Hit, Long> {
}