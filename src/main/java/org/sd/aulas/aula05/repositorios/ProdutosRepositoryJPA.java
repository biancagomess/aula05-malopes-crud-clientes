package org.sd.aulas.aula05.repositorios;

import org.sd.aulas.aula05.entidades.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutosRepositoryJPA extends JpaRepository<Produtos, Long> {

	@Query("select prod from Produtos prod where prod.id = ?1")
	public Produtos findByProdId(Long id);
}
