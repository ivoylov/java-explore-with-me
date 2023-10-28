package ru.practicum.statisticservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.statisticservice.model.Hit;
import ru.practicum.statisticservice.model.HitDtoIn;
import ru.practicum.statisticservice.model.HitMapper;
import ru.practicum.statisticservice.model.StatDtoOut;

import javax.transaction.Transactional;
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

    @Transactional
    @PostMapping("/hit")
    public Hit putHit(@Validated(Create.class) @RequestBody HitDtoIn hitDtoIn) {
        log.info("{}; /hitDtoIn; {}", this.getClass(), hitDtoIn);
        Hit hit = HitMapper.toHit(hitDtoIn);
        log.info("{}; transformed to Hit; {}", this.getClass(), hit);
        Hit savedHit = statisticService.put(hit);
        log.info("{}; saved hit; {}", this.getClass(), savedHit);
        return savedHit;
    }

    @Transactional
    @GetMapping("/stats")
    public List<StatDtoOut> getHits(@RequestParam("start") String stringStart,
                              @RequestParam("end") String stringEnd,
                              @RequestParam @Nullable List<String> uris,
                              @RequestParam (defaultValue = "false") Boolean unique) {
        log.info("{}; /stats; stringStart={}, stringEnd={}, uris={}, unique={}",
                this.getClass(), stringStart, stringEnd, uris, unique);
        return statisticService.getStatistic(stringStart, stringEnd, uris, unique, "ewm-main-service");
    }

}
