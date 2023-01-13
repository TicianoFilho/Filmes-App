package br.com.cubo.filmesapi.controller;

import br.com.cubo.filmesapi.domain.dto.FilmeSaveDto;
import br.com.cubo.filmesapi.domain.dto.FilmeShowDto;
import br.com.cubo.filmesapi.domain.dto.FilmeUpdateDto;
import br.com.cubo.filmesapi.service.FilmeService;
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
    public Page<FilmeShowDto> getAllFilmes(@PageableDefault(
            page = 0, size = 5, sort = "id") Pageable pageable) {
        return filmeService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FilmeShowDto saveFilme(@RequestBody FilmeSaveDto dto) {
        return filmeService.save(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeUpdateDto updateFilmeById(@PathVariable(name = "id") Long id,
                                          @RequestBody FilmeUpdateDto updateDto) {
        return filmeService.update(id, updateDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeShowDto getFilmeById(@PathVariable(name = "id") Long id) {
        return filmeService.getById(id).get();
    }
}
