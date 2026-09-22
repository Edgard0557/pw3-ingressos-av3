package br.com.etechoracio.ingresso.mapper;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.dto.FilmeSessoesResponseDTO;
import br.com.etechoracio.ingresso.entity.Filme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = FilmeMapper.class)
public interface FilmeMapper {

    List<FilmeResponseDTO> toRespostaDTOList(List<Filme> entities);

    FilmeSessoesResponseDTO toSessoesResponseDTO(Filme entity);

}
