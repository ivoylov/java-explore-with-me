package ru.practicum.mainservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.practicum.mainservice.model.Hit;
import ru.practicum.mainservice.model.HitDtoIn;
import ru.practicum.mainservice.model.StatDtoOut;

import java.util.Arrays;

@RestController
@Slf4j
public class MainController {

    @Value(value = "${server-stat-url}")
    private String serverStatURL;

    @GetMapping("/ping")
    public String ping() {
        log.info("{}; /ping", this.getClass());
        return "main server is working";
    }

    @PostMapping("/hit")
    public Hit putHit(@Validated(Create.class) @RequestBody HitDtoIn hitDtoIn) {
        log.info("{}; /hit; {}", this.getClass(), hitDtoIn);
        WebClient webClient = WebClient.create();
        Mono<Hit> statisticServerAnswer = webClient.post()
                .uri(serverStatURL + "/hit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(hitDtoIn))
                .retrieve()
                .bodyToMono(Hit.class);
        return statisticServerAnswer.blockOptional().get();
    }

    @GetMapping("/stats")
    public StatDtoOut getHits(@RequestParam("start") String stringStart,
                              @RequestParam("end") String stringEnd,
                              @RequestParam String[] uris,
                              @RequestParam Boolean unique) {
        log.info("{}; /stats; stringStart={}, stringEnd={}, uris={}, unique={}",
                this.getClass(), stringStart, stringEnd, uris, unique);
        WebClient webClient = WebClient.create();
        Mono<StatDtoOut> statisticAnswer = webClient.get()
                .uri(String.format(serverStatURL + "/stats?start=%s&end=%s&uris=%s&unique=%s",
                        stringStart, stringEnd, Arrays.toString(uris), unique.toString()))
                .retrieve()
                .bodyToMono(StatDtoOut.class);
        return statisticAnswer.blockOptional().get();
    }

}
