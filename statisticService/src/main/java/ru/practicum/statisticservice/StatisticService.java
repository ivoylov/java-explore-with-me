package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.statisticservice.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StatisticService {

    StatisticRepository statisticRepository;

    public Hit put(Hit hit) {
        return statisticRepository.save(hit);
    }

    public List<Hit> getStatistic(LocalDateTime start, LocalDateTime end, String[] uris, Boolean unique) {
        return statisticRepository.findAll();
    }

}
