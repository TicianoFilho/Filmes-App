package br.com.cubo.filmesapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String ano;

    private String duracao;

    @ManyToMany
    @JoinTable(
            name = "filmes_categorias",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    public Filme() {
        this.categorias = new ArrayList<>();
    }
}
