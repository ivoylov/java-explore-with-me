package ru.practicum.mainservice.compilation.conrollers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.compilation.CompilationService;
import ru.practicum.mainservice.compilation.dto.CompilationDto;
import ru.practicum.mainservice.compilation.dto.NewCompilationDto;
import ru.practicum.mainservice.compilation.dto.UpdateCompilationRequest;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/compilations")
public class AdminCompilationController {

    private final CompilationService compilationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompilationDto adminAddCompilation(
            @RequestBody @Valid NewCompilationDto newCompilationDto
    ) {
        log.info("POST /admin/compilations - Adding a new selection.");
        return compilationService.adminAddCompilation(newCompilationDto);
    }

    @DeleteMapping("/{compId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adminRemoveCompilation(
            @PathVariable long compId
    ) {
        log.info("POST /admin/compilations/{} - Deleting a selection.", compId);
        compilationService.adminRemoveCompilation(compId);
    }

    @PatchMapping("/{compId}")
    public CompilationDto adminUpdateCompilation(
            @PathVariable long compId,
            @RequestBody @Valid UpdateCompilationRequest updateCompilationRequest
    ) {
        log.info("PATCH /admin/compilations/{} - Update information about the selection.", compId);
        return compilationService.adminUpdateCompilation(compId, updateCompilationRequest);
    }

}
