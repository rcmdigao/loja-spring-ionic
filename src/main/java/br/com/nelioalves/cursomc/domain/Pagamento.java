package br.com.nelioalves.cursomc.domain;


import br.com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // Uma tabela para cada subclasse (Cartao e Boleto)
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private EstadoPagamento estado;

    @OneToOne // mesmo id do pedido
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

}
