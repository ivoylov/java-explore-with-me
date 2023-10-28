package ru.practicum.statisticservice.model;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class HitMapper {
    public static Hit toHit(HitDtoIn hitDtoIn) {
        log.info("{}; toHit; {}", HitMapper.class, hitDtoIn);
        String datePattern = "yyyy-MM-dd HH:mm:ss";
        return Hit.builder()
                .app(hitDtoIn.getApp())
                .uri(hitDtoIn.getUri())
                .ip(hitDtoIn.getIp())
                .timestamp(LocalDateTime.parse(hitDtoIn.getTimestamp(), DateTimeFormatter.ofPattern(datePattern)))
                .build();
    }
}
