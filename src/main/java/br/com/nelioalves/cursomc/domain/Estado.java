package br.com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Estado implements Serializable {

    private static final long serialVersionUID = -2920102208420305923L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @JsonBackReference // Do outro lado da associacao já foram referenciados, não preciso mais buscar.
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();
}
