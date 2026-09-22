package br.com.etechoracio.ingresso.dto;

import java.time.LocalDateTime;

public record SessaoSalaResponseDTO(
        Long id,
        LocalDateTime data,
        Double preco,
        SalaResponseDTO sala
) { }
