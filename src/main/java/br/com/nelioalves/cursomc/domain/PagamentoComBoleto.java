package br.com.nelioalves.cursomc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1l;
    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, Integer estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido); // Pegando da classe mae
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }




}
