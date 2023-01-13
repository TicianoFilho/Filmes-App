package br.com.cubo.filmesapi.service;

import br.com.cubo.filmesapi.domain.dto.FilmeSaveDto;
import br.com.cubo.filmesapi.domain.dto.FilmeShowDto;
import br.com.cubo.filmesapi.domain.dto.FilmeUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface FilmeService {
    FilmeShowDto save(FilmeSaveDto dto);

    FilmeUpdateDto update(Long id, FilmeUpdateDto dto);

    Page<FilmeShowDto> getAll(Pageable pageable);

    Optional<FilmeShowDto> getById(Long id);

    void delete(Long id);
}
