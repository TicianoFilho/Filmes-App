package br.com.cubo.filmesapi.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilmeShowDto {

    private String descricao;

    private String ano;

    private String duracao;

    private List<CategoriaDto> categorias;
}
