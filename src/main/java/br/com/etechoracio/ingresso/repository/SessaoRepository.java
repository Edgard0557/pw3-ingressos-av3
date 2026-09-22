package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SessaoRepository extends
        JpaRepository<Sessao, Long> {
    @Query("SELECT s FROM Sessao s join fetch s.sala WHERE s.filme.id = :idFilme" +
            " AND s.data >= :date AND s.dataExclusao IS NULL")
    List<Sessao> findByIdFilme(Long idFilme,
                               LocalDateTime date);

}
