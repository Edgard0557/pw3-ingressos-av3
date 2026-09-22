package br.com.etechoracio.ingresso.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_SESSAO")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSAO")
    private Long id;

    @Column(name = "DT_DATA")
    private LocalDateTime data;

    @Column(name = "NR_PRECO")
    private Double preco;

    @Column(name = "ID_SALA", insertable = false, updatable = false)
    private Long salaId;

    @Column(name = "ID_FILME", insertable = false, updatable = false)
    private Long filmeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALA")
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FILME")
    private Filme filme;

    @Column(name = "DT_EXCLUSAO")
    private LocalDateTime dataExclusao;

}
