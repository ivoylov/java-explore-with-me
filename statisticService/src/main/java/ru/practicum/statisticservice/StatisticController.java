package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.statisticservice.model.Hit;
import ru.practicum.statisticservice.model.HitDtoIn;
import ru.practicum.statisticservice.model.HitMapper;
import ru.practicum.statisticservice.model.StatDtoOut;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class StatisticController {

    private StatisticService statisticService;

    @GetMapping("/ping")
    public String ping() {
        return "statistic server is work";
    }

    @PostMapping("/hit")
    public Hit putHit(@Validated(Create.class) @RequestBody HitDtoIn hitDtoIn) {
        log.info("{}; /hit; {}", this.getClass(), hitDtoIn);
        Hit hit = HitMapper.toHit(hitDtoIn);
        return statisticService.put(hit);
    }

    @GetMapping("/stats")
    public StatDtoOut getHits(LocalDateTime start, LocalDateTime end, String[] uris, Boolean unique) {
        log.info("{}; /stats;", this.getClass());
        List<Hit> hits = statisticService.getStatistic(start, end, uris, unique);
        return HitMapper.toStatDtoOut(hits, "ewm-main-service", uris);
    }

}
