package ru.practicum.mainservice.compilation.conrollers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.compilation.CompilationService;
import ru.practicum.mainservice.compilation.dto.CompilationDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/compilations")
public class PublicCompilationController {

    private final CompilationService compilationService;

    @GetMapping
    public List<CompilationDto> getCompilations(
            @RequestParam(defaultValue = "false") boolean pinned,
            @RequestParam(defaultValue = "0") @PositiveOrZero int from,
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        log.info("GET /compilations?pinned={}&from={}&size={} - Getting collections of events.",
                pinned, from, size);
        return compilationService.getCompilations(pinned, from, size);
    }

    @GetMapping("/{compId}")
    public CompilationDto getCompilation(
            @PathVariable long compId
    ) {
        log.info("GET /compilation/{} - Getting a selection of events by its id.", compId);
        return compilationService.getCompilation(compId);
    }

}
