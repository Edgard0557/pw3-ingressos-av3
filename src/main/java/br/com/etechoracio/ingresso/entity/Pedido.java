package br.com.etechoracio.ingresso.entity;

import br.com.etechoracio.ingresso.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long id;

    @Column(name = "TX_NUMERO")
    private String numero;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_STATUS")
    private StatusPedidoEnum status;

    @OneToOne(mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToMany
    @JoinTable(name = "TBL_REL_PEDIDO_INGRESSO",
            joinColumns = @JoinColumn(name = "ID_PEDIDO"),
            inverseJoinColumns = @JoinColumn(name = "ID_INGRESSO"))
    private List<Ingresso> ingressos;

}
