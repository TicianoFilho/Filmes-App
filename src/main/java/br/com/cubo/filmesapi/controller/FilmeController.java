package br.com.cubo.filmesapi.controller;

import br.com.cubo.filmesapi.domain.dto.FilmeSaveDto;
import br.com.cubo.filmesapi.domain.dto.FilmeShowDto;
import br.com.cubo.filmesapi.domain.dto.FilmeUpdateDto;
import br.com.cubo.filmesapi.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Filme", summary = "Busca todos os filmes")
    public Page<FilmeShowDto> getAllFilmes(@PageableDefault(
            page = 0, size = 5, sort = "id") Pageable pageable) {
        return filmeService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Filme", summary = "Busca um filme pelo ID")
    public FilmeShowDto getFilmeById(@PathVariable(name = "id") Long id) {
        return filmeService.getById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = "Filme", summary = "Cria um novo filme")
    public FilmeShowDto saveFilme(@RequestBody FilmeSaveDto dto) {
        return filmeService.save(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Filme", summary = "Atualiza um filme")
    public FilmeUpdateDto updateFilmeById(@PathVariable(name = "id") Long id,
                                          @RequestBody FilmeUpdateDto updateDto) {
        return filmeService.update(id, updateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(tags = "Filme", summary = "Exclui um filme")
    public void deleteFilme(@PathVariable(name = "id") Long id) {
        filmeService.delete(id);
    }

}
