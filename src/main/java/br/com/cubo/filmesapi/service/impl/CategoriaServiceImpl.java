package br.com.cubo.filmesapi.service.impl;

import br.com.cubo.filmesapi.domain.builder.CategoriaDtoBuilder;
import br.com.cubo.filmesapi.domain.dto.CategoriaDto;
import br.com.cubo.filmesapi.domain.model.Categoria;
import br.com.cubo.filmesapi.repository.CategoriaRepository;
import br.com.cubo.filmesapi.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDto save(CategoriaDto dto) {

        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(dto, categoria);

        Categoria newCategoria = categoriaRepository.save(categoria);

        BeanUtils.copyProperties(newCategoria, dto);
        return dto;
    }

    @Override
    public Page<CategoriaDto> getAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable).map(categoria -> {
            return CategoriaDto.builder()
                    .descricao(categoria.getDescricao())
                    .build();
        });
    }

    @Override
    public Optional<CategoriaDto> getById(Long id) {
        return categoriaRepository.findById(id).map(categoria -> {
            return CategoriaDto.builder()
                    .descricao(categoria.getDescricao())
                    .build();
        });
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaDto update(Long id, CategoriaDto dto) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoria.setDescricao(dto.getDescricao());
        Categoria updatedCategoria = categoriaRepository.save(categoria);

        BeanUtils.copyProperties(updatedCategoria, dto);
        return dto;
    }
}
