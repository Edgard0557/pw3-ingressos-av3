package br.com.etechoracio.ingresso.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_LUGAR")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LUGAR")
    private Long id;

    @Column(name = "TX_FILEIRA")
    private String fileira;

    @Column(name = "NR_POSICAO")
    private Integer posicao;

    @Column(name = "ID_SALA", insertable = false, updatable = false)
    private Long salaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALA")
    private Sala sala;

}
