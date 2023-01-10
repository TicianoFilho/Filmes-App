package br.com.cubo.filmesapi.service.impl;

import br.com.cubo.filmesapi.domain.model.Filme;
import br.com.cubo.filmesapi.repository.FilmeRepository;
import br.com.cubo.filmesapi.service.FilmeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    @Override
    public Page<Filme> getAll(Pageable pageable) {
        return filmeRepository.findAll(pageable);
    }

    @Override
    public Optional<Filme> getById(UUID id) {
        return filmeRepository.findById(id);
    }

    @Override
    public void delete(Filme filme) {
        filmeRepository.delete(filme);
    }
}
