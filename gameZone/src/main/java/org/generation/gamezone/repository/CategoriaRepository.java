package org.generation.gamezone.repository;

import java.util.List;


import org.generation.gamezone.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
public List<Categoria> findAllByGeneroContainingIgnoreCase(String genero);
}
