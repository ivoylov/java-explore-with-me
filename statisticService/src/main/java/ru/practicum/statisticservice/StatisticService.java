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

    public List<Hit> getStatistic(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        log.info("{}; /getStatistic; start={}, end={}, uris={}, unique={}", this.getClass(), start, end, uris, unique);
        List<Hit> hits;
        if (uris.size() == 0) {
            log.info("get all uris, because uris.size = 0");
            hits = statisticRepository.findAllUris(start, end);
        } else {
            log.info("get some uris, because uris.size != 0");
            hits = statisticRepository.findSomeUris(start, end, uris);
        }
        log.info("{}; got hits; {}", this.getClass(), hits);
        if (unique) {
            Set<Hit> setHits = new TreeSet<>(Comparator.comparing(Hit::getIp));
            setHits.addAll(hits);
            log.info("{}; hits after duplicate delete; {}", this.getClass(), setHits);
            return new ArrayList<>(setHits);
        }
        return hits;
    }

}
