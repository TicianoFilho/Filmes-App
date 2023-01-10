package br.com.cubo.filmesapi.service.impl;

import br.com.cubo.filmesapi.domain.model.Filme;
import br.com.cubo.filmesapi.service.FilmeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Override
    public Filme save(Filme filme) {
        return null;
    }

    @Override
    public Page<Filme> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Filme> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void delete(Filme filme) {

    }
}
