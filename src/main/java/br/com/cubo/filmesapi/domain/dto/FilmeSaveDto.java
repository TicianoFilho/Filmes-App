package br.com.cubo.filmesapi.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class FilmeSaveDto {

    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

    @Range(min = 4, max = 4, message = "O ano deve ser completo. Ex: 1987")
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String ano;

    private String duracao;

    private List<UUID> categoriaIds;
}
