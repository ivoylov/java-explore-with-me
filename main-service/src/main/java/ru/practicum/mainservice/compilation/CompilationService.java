package ru.practicum.mainservice.compilation;

import ru.practicum.mainservice.compilation.dto.CompilationDto;
import ru.practicum.mainservice.compilation.dto.NewCompilationDto;
import ru.practicum.mainservice.compilation.dto.UpdateCompilationRequest;

import java.util.List;

public interface CompilationService {

    CompilationDto adminAddCompilation(NewCompilationDto newCompilationDto);

    void adminRemoveCompilation(long compilationId);

    CompilationDto adminUpdateCompilation(long compilationId, UpdateCompilationRequest compilationRequest);

    List<CompilationDto> getCompilations(boolean pinned, int from, int size);

    CompilationDto getCompilation(long compilationId);

}
