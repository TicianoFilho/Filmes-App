package br.com.cubo.filmesapi.service;

import br.com.cubo.filmesapi.domain.model.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface FilmeService {
    Filme save(Filme filme);
    Page<Filme> getAll(Pageable pageable);
    Optional<Filme> getById(UUID id);
    void delete(Filme filme);
}
