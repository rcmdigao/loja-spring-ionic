package br.com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = -2920102208420305923L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonBackReference // Do outro lado da associacao já foram referenciados, não preciso mais buscar.
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
