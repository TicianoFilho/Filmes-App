package br.com.cubo.filmesapi.controller;

import br.com.cubo.filmesapi.domain.dto.CategoriaDto;
import br.com.cubo.filmesapi.service.CategoriaService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CategoriaDto> getAllCategorias(
            @PageableDefault(page = 0, size = 5, sort = "id") Pageable pageable) {
        return categoriaService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto saveCategoria(@RequestBody CategoriaDto dto) {
        System.out.println("okkk");
        return categoriaService.save(dto);
    }

}
