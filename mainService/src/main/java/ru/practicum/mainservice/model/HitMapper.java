package ru.practicum.mainservice.model;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class HitMapper {
    public static Hit toHit(HitDtoIn hitDtoIn) {
        log.info("HitMapper; toHit; {}", hitDtoIn);
        return Hit.builder()
                .app(hitDtoIn.getApp())
                .uri(hitDtoIn.getUri())
                .ip(hitDtoIn.getIp())
                .timestamp(hitDtoIn.getTimestamp())
                .build();
    }

    public static StatDtoOut toStatDtoOut(List<Hit> hits, String app, String[] uris) {
        log.info("HitMapper; toStatDtoOut");
        return StatDtoOut.builder()
                .app(app)
                .uris(uris)
                .hits(hits.size())
                .build();
    }

}
