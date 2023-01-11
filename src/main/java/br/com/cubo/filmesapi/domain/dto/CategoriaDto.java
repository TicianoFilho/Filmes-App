package br.com.cubo.filmesapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaDto {

    private String descricao;
}
