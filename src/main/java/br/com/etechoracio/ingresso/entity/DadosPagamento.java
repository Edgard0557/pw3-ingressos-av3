package br.com.etechoracio.ingresso.entity;

import br.com.etechoracio.ingresso.enums.TipoFormaPagamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_DADOS_PAGAMENTO")
public class DadosPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DADOS_PAGAMENTO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_NUMERO")
    private String numero;

    @Column(name = "TX_EXPIRACAO")
    private String expiracao;

    @Column(name = "TX_BANDEIRA")
    private String bandeira;

    @Column(name = "TX_CODIGO")
    private String codigo;

    @Column(name = "NR_PARCELAS")
    private Integer parcelas;

    @Column(name = "NR_VALOR")
    private Double valor;

    @JoinColumn(name = "ID_PAGAMENTO")
    @OneToOne(fetch = FetchType.LAZY)
    private Pagamento pagamento;

    @Column(name = "TP_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoFormaPagamentoEnum tipo;

}
