package br.com.etechoracio.ingresso.entity;

import br.com.etechoracio.ingresso.enums.TipoIngressoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_INGRESSO")
public class Ingresso {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_INGRESSO")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_INGRESSO")
    private TipoIngressoEnum tipo;

    @Column(name = "NR_PRECO")
    private Double preco;

    @Column(name = "ID_SESSAO", insertable = false, updatable = false)
    private Long idSessao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SESSAO")
    private Sessao sessao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LUGAR")
    private Lugar lugar;

}
