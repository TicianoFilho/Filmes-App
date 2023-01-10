package br.com.cubo.filmesapi.repository;

import br.com.cubo.filmesapi.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
