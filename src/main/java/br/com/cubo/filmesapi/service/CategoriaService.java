package br.com.cubo.filmesapi.service;

import br.com.cubo.filmesapi.domain.dto.CategoriaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaService {
    CategoriaDto save(CategoriaDto dto);

    CategoriaDto update(Long id, CategoriaDto dto);

    Page<CategoriaDto> getAll(Pageable pageable);

    Optional<CategoriaDto> getById(Long id);

    void delete(Long id);


}
