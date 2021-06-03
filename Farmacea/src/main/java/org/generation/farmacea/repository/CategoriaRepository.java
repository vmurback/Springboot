package org.generation.farmacea.repository;

import java.util.List;

import org.generation.farmacea.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByMedicamentoContainingIgnoreCase(String medicamento);
}
