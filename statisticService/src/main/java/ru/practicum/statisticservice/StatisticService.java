package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.statisticservice.model.Hit;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class StatisticService {

    StatisticRepository statisticRepository;

    public Hit put(Hit hit) {
        log.info("{}; /put; {}", this.getClass(), hit);
        return statisticRepository.save(hit);
    }

    public List<Hit> getStatistic(LocalDateTime start, LocalDateTime end, String[] uris, Boolean unique) {
        log.info("{}; /getStatistic; start={}, end={}, uris={}, unique={}", this.getClass(), start, end, uris, unique);
        List<Hit> hits = statisticRepository.find(start, end, uris);
        if (unique) {
            Set<Hit> setHits = new TreeSet<>(Comparator.comparing(Hit::getIp));
            setHits.addAll(hits);
            return new ArrayList<>(setHits);
        }
        return hits;
    }

}
