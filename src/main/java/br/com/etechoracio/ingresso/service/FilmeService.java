package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.dto.FilmeSessoesResponseDTO;
import br.com.etechoracio.ingresso.entity.Sessao;
import br.com.etechoracio.ingresso.enums.SimNaoEnum;
import br.com.etechoracio.ingresso.mapper.FilmeMapper;
import br.com.etechoracio.ingresso.repository.FilmeRepository;
import br.com.etechoracio.ingresso.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private FilmeMapper filmeMapper;

    @Autowired
    private SessaoRepository sessaoRepository;

    public List<FilmeResponseDTO> findByEmCartaz() {
        var result = filmeRepository.findByEmCartazAndDataExclusaoIsNull(SimNaoEnum.S);
        return filmeMapper.toRespostaDTOList(result);
    }

    public Optional<FilmeSessoesResponseDTO> findByIdWithSessoes(Long id){
        return filmeRepository.findById(id).map(filme ->{
            var sessoes = sessaoRepository.findByIdFilme(id, LocalDateTime.now());
            filme.setSessoes(sessoes);
            return filmeMapper.toSessoesResponseDTO(filme);
        });
    }

}
