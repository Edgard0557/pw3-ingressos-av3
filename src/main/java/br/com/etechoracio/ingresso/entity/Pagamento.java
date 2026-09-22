package br.com.etechoracio.ingresso.entity;

import br.com.etechoracio.ingresso.enums.StatusPagamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long id;

    @Column(name = "NR_VALOR")
    private Double valor;

    @Column(name = "TP_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;

    @JoinColumn(name = "ID_PEDIDO")
    @OneToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @OneToOne(mappedBy = "pagamento")
    private DadosPagamento dadosPagamento;

}
