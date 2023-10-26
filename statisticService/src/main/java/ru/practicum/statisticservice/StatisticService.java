package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.statisticservice.model.Hit;
import ru.practicum.statisticservice.model.StatDtoOut;

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

    public List<Hit> getHits(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        log.info("{}; /getStatistic; start={}, end={}, uris={}, unique={}", this.getClass(), start, end, uris, unique);
        List<Hit> hits;
        if (uris.size() == 0) {
            log.info("get all uris, because uris size = 0");
            hits = statisticRepository.findAllUris(start, end);
        } else {
            log.info("get some uris, because uris size != 0");
            hits = statisticRepository.findSomeUris(start, end, uris);
        }
        log.info("{}; got hits; {}", this.getClass(), hits);
        return hits;
    }

    public List<StatDtoOut> prepareStatistic(List<Hit> hits, Boolean unique, String app) {
        log.info("{}; prepare statistic", this.getClass());
        HashMap<String, HashMap<String, Integer>> statistic = new HashMap<>();
        for (Hit hit : hits) {
            if (statistic.containsKey(hit.getUri())) {
                HashMap<String, Integer> ipValues =  statistic.get(hit.getUri());
                if (ipValues.containsKey(hit.getIp())) {
                    if (!unique) {
                        Integer ipCount = ipValues.get(hit.getIp());
                        ipCount++;
                        ipValues.put(hit.getIp(), ipCount);
                    }
                } else {
                    ipValues.put(hit.getIp(), 1);
                }
            } else {
                statistic.put(hit.getUri(), new HashMap<>());
                statistic.get(hit.getUri()).put(hit.getIp(), 1);
            }
        }
        log.info("{}; prepared statistic; {}", this.getClass(), statistic);
        List<StatDtoOut> result = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, Integer>> stat : statistic.entrySet()) {
            int visitCount = 0;
            for (Map.Entry<String, Integer> ipStat : stat.getValue().entrySet()) {
                visitCount += ipStat.getValue();
            }
            result.add(new StatDtoOut(app, stat.getKey(), visitCount));
        }
        log.info("{}; prepared StatDtoOut list; {}", this.getClass(), result);
        return result;
    }

    public List<StatDtoOut> getStatistic(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique, String app) {
        log.info("{}; get statistic", this.getClass());
        List<Hit> hits = getHits(start, end, uris, unique);
        log.info("{}; get hits; {}", this.getClass(), hits);
        List<StatDtoOut> statDtoOutList = prepareStatistic(hits, unique, app);
        log.info("{}; get StatDtoOut list; {}", this.getClass(), statDtoOutList);
        return statDtoOutList;
    }

}
