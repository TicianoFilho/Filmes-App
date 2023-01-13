package br.com.cubo.filmesapi.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FilmeAddCategoriaDto {

    private List<Long> categoriaIds;
}
