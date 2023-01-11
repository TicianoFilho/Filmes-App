package br.com.cubo.filmesapi.service.impl;

import br.com.cubo.filmesapi.domain.dto.CategoriaDto;
import br.com.cubo.filmesapi.domain.dto.FilmeSaveDto;
import br.com.cubo.filmesapi.domain.dto.FilmeShowDto;
import br.com.cubo.filmesapi.domain.model.Filme;
import br.com.cubo.filmesapi.repository.FilmeRepository;
import br.com.cubo.filmesapi.service.FilmeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public FilmeShowDto save(FilmeSaveDto dto) {
        Filme filme = new Filme();
        BeanUtils.copyProperties(dto, filme);

        Filme newFilme = filmeRepository.save(filme);

        return FilmeShowDto.builder()
                .descricao(newFilme.getDescricao())
                .ano(newFilme.getAno())
                .duracao(newFilme.getDuracao())
                .categorias(newFilme.getCategorias().stream().map(categoria -> {
                    return CategoriaDto.builder()
                            .descricao(categoria.getDescricao())
                            .build();
                }).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Page<FilmeShowDto> getAll(Pageable pageable) {
        Page<Filme> filmesPage = filmeRepository.findAll(pageable);

//        Page<FilmeShowDto> dtoPage = filmesPage.map(filme -> {
//            return FilmeShowDto.builder()
//                    .descricao(filme.getDescricao())
//                    .ano(filme.getAno())
//                    .duracao(filme.getDuracao())
//                    .categorias(filme.getCategorias().stream().map(
//                            categoria -> categoria.getId()).collect(Collectors.toList()))
//                    .build();
//        });
        return null;
    }

    @Override
    public Optional<FilmeShowDto> getById(UUID id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Nenhum filme foi encontrado."));

//        return Optional.of(FilmeShowDto.builder()
//                .descricao(filme.getDescricao())
//                .ano(filme.getAno())
//                .duracao(filme.getDuracao())
//                .categorias(filme.getCategorias().stream().map(
//                        categoria -> categoria.getId()).collect(Collectors.toList()))
//                .build());
        return null;
    }

    @Override
    public void delete(UUID id) {
       // filmeRepository.delete(filme);
    }
}
