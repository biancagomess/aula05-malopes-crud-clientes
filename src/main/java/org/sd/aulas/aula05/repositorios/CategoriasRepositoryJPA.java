package org.sd.aulas.aula05.repositorios;

import org.sd.aulas.aula05.entidades.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriasRepositoryJPA extends JpaRepository<Categorias, Long>{

	@Query("select categ from Categorias categ where categ.id = ?1")
	public Categorias findByCategId(Long id);
}
