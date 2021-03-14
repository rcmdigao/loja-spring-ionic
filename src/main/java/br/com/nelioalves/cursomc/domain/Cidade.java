package br.com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Cidade implements Serializable {

    private static final long serialVersionUID = -2920102208420305923L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @JsonManagedReference // Coloca onde vai mostrar os objetos associados (Json Ciclica)
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}
