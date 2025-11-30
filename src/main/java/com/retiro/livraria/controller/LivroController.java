package com.retiro.livraria.controller;

import com.retiro.livraria.dto.LivroAtualizacaoDTO;
import com.retiro.livraria.dto.LivroCadastroDTO;
import com.retiro.livraria.dto.LivroResponseDTO;
import com.retiro.livraria.service.LivroService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retiro/livraria/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService service;
    @GetMapping
    public List<LivroResponseDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public LivroResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping(value = "/cadastrar" , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LivroResponseDTO cadastrar(@RequestBody LivroCadastroDTO dto) {
        return service.criar(dto);
    }

    @PutMapping(value = "/atualizar/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LivroResponseDTO  atualizar(@PathVariable Long id, @RequestBody LivroAtualizacaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}/remover")
    public void remover(@PathVariable Long id) {
        service.deletar(id);
    }

    @PatchMapping("/{id}/vender")
    public LivroResponseDTO vender(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        return service.vender(id, quantidade);
    }
}
