package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.statisticservice.model.Hit;
import ru.practicum.statisticservice.model.HitDtoIn;
import ru.practicum.statisticservice.model.HitMapper;
import ru.practicum.statisticservice.model.StatDtoOut;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class StatisticController {

    private StatisticService statisticService;

    @GetMapping("/ping")
    public String ping() {
        log.info("{}; /ping", this.getClass());
        return "statistic server is work";
    }

    @PostMapping("/hit")
    public Hit putHit(@Validated(Create.class) @RequestBody HitDtoIn hitDtoIn) {
        log.info("{}; /hitDtoIn; {}", this.getClass(), hitDtoIn);
        Hit hit = HitMapper.toHit(hitDtoIn);
        log.info("{}; transformed to Hit; {}", this.getClass(), hit);
        Hit savedHit = statisticService.put(hit);
        log.info("{}; saved hit; {}", this.getClass(), savedHit);
        return savedHit;
    }

    @GetMapping("/stats")
    public StatDtoOut getHits(@RequestParam("start") String stringStart,
                              @RequestParam("end") String stringEnd,
                              @RequestParam String[] uris,
                              @RequestParam Boolean unique) {
        log.info("{}; /stats; stringStart={}, stringEnd={}, uris={}, unique={}",
                this.getClass(), stringStart, stringEnd, uris, unique);
        String datePattern = "yyyy-MM-dd'T'HH:mm:ss";
        LocalDateTime start = LocalDateTime.parse(stringStart, DateTimeFormatter.ofPattern(datePattern));
        LocalDateTime end = LocalDateTime.parse(stringEnd, DateTimeFormatter.ofPattern(datePattern));
        log.info("{}; /stats; start={}, end={}, uris={}, unique={}",
                this.getClass(), start, end, uris, unique);
        List<Hit> hits = statisticService.getStatistic(start, end, uris, unique);
        log.info("{}; got hits; {}", this.getClass(), hits);
        return HitMapper.toStatDtoOut(hits, "ewm-main-service", uris);
    }

}
