package br.com.cubo.filmesapi.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class FilmeUpdateDto {
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

    @Range(min = 4, max = 4, message = "O ano deve ser completo. Ex: 1987")
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String ano;

    private String duracao;
}
