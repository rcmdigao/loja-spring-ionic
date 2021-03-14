package br.com.nelioalves.cursomc.repositories;

import br.com.nelioalves.cursomc.domain.Categoria;
import br.com.nelioalves.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
