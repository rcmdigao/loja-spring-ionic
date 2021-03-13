package br.com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categoria implements Serializable {

    private static final long serialVersionUID = -2920102208420305923L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


    @JsonManagedReference // Coloca onde vai mostrar os objetos associados
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();


}
