package br.com.etechoracio.ingresso.dto;

import br.com.etechoracio.ingresso.enums.CategoriaFilmeEnum;
import br.com.etechoracio.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingresso.enums.SimNaoEnum;

import java.util.List;

public record FilmeSessoesResponseDTO(
        Long id,
        String nome,
        long duracao,
        CategoriaFilmeEnum categoria,
        ClassificacaoIndicativaEnum classificacao,
        Integer ano,
        String capa,
        String diretor,
        String elenco,
        String descricao,
        Double avaliacao,
        SimNaoEnum emCartaz,
        List<SessaoSalaResponseDTO> sessoes
) { }

