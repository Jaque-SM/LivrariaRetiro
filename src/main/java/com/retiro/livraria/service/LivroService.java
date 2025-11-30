package com.retiro.livraria.service;

import com.retiro.livraria.dto.LivroAtualizacaoDTO;
import com.retiro.livraria.dto.LivroCadastroDTO;
import com.retiro.livraria.dto.LivroResponseDTO;
import com.retiro.livraria.mapper.LivroMapper;
import com.retiro.livraria.model.Livro;
import com.retiro.livraria.repository.LivroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;
    private final LivroMapper mapper;

    public List<LivroResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public LivroResponseDTO buscarPorId(Long id) {
        return mapper.toDTO(buscarEntidade(id));
    }

    public LivroResponseDTO criar(LivroCadastroDTO dto) {
        Livro livro = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(livro));
    }

    public LivroResponseDTO atualizar(Long id, LivroAtualizacaoDTO dto) {
        Livro livro = buscarEntidade(id);
        mapper.atualizarLivroFromDTO(dto, livro);
        return mapper.toDTO(repository.save(livro));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public LivroResponseDTO vender(Long id, Integer quantidade) {
        Livro livro = buscarEntidade(id);

        if (livro.getEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        livro.setEstoque(livro.getEstoque() - quantidade);
        return mapper.toDTO(repository.save(livro));
    }

    private Livro buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
