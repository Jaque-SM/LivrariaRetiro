package com.retiro.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroAtualizacaoDTO {
    private String titulo;
    private String autor;
    private Double preco;
    private Integer estoque;
    private String categoria;
}
