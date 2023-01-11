package br.com.cubo.filmesapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class CategoriaDto {

    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

    // TODO implement the Design Pattern Builder manually because the @Builder is not working with a single property
}
