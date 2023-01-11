package br.com.cubo.filmesapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

}
