package com.retiro.livraria.mapper;

import com.retiro.livraria.dto.LivroAtualizacaoDTO;
import com.retiro.livraria.dto.LivroCadastroDTO;
import com.retiro.livraria.dto.LivroResponseDTO;
import com.retiro.livraria.model.Livro;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LivroMapper {
    LivroResponseDTO toDTO(Livro livro);

    Livro toEntity(LivroCadastroDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarLivroFromDTO(LivroAtualizacaoDTO dto, @MappingTarget Livro livro);
}
