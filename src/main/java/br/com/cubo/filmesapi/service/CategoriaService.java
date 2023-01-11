package br.com.cubo.filmesapi.service;

import br.com.cubo.filmesapi.domain.dto.CategoriaDto;
import br.com.cubo.filmesapi.domain.dto.FilmeSaveDto;
import br.com.cubo.filmesapi.domain.dto.FilmeShowDto;
import br.com.cubo.filmesapi.domain.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaService {
    CategoriaDto save(CategoriaDto dto);
    Page<CategoriaDto> getAll(Pageable pageable);
    Optional<CategoriaDto> getById(UUID id);
    void delete(UUID id);
}
