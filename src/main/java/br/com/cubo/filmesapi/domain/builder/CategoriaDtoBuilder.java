package br.com.cubo.filmesapi.domain.builder;

import br.com.cubo.filmesapi.domain.dto.CategoriaDto;

public class CategoriaDtoBuilder {

    private String descricao;

    public CategoriaDtoBuilder() {

    }

    public static CategoriaDtoBuilder builder() {
        return new CategoriaDtoBuilder();
    }

    public CategoriaDtoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public CategoriaDto build() {
        return this.descricao.isBlank() ? null : new CategoriaDto(this.descricao);
    }
}
