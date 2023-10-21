package ru.practicum.mainservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.practicum.mainservice.model.Hit;
import ru.practicum.mainservice.model.HitDtoIn;

@RestController
@AllArgsConstructor
@Slf4j
public class MainController {

    @GetMapping("/ping")
    public String ping() {
        log.info("{}; /ping", this.getClass());
        WebClient webClient = WebClient.create();
        Mono<String> statisticServerAnswer = webClient.get()
                .uri("http://localhost:9090/ping")
                .retrieve()
                .bodyToMono(String.class);
        return "main server is working\n" + statisticServerAnswer.blockOptional().get();
    }

    @PostMapping("/hit")
    public Hit putHit(@Validated(Create.class) @RequestBody HitDtoIn hitDtoIn) {
        log.info("{}; /hit; {}", this.getClass(), hitDtoIn);
        WebClient webClient = WebClient.create();
        Mono<Hit> statisticServerAnswer = webClient.post()
                .uri("http://localhost:9090/hit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(hitDtoIn))
                .retrieve()
                .bodyToMono(Hit.class);
        return statisticServerAnswer.blockOptional().get();
    }

    @GetMapping("/stats")
    public void getHits(@RequestParam("start") String stringStart,
                              @RequestParam("end") String stringEnd,
                              @RequestParam String[] uris,
                              @RequestParam Boolean unique) {
        log.info("{}; /stats; stringStart={}, stringEnd={}, unique={}", this.getClass(), stringStart, stringEnd, unique);
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090/stats")
                .build();
        webClient.post();
    }

}
