package br.com.nelioalves.cursomc.repositories;

import br.com.nelioalves.cursomc.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaegoriaRepository extends JpaRepository<Categoria, Integer> {
}
