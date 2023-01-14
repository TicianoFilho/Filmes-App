package br.com.cubo.filmesapi.repository;

import br.com.cubo.filmesapi.domain.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    boolean existsByDescricao(String descricao);
}
