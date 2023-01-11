package br.com.cubo.filmesapi.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

    public CategoriaDto(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaDto() {

    }
}
