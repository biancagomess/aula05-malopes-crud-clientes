package org.sd.aulas.aula05.controladores;

import java.util.List;

import org.sd.aulas.aula05.entidades.Produtos;

import org.sd.aulas.aula05.repositorios.ProdutosRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")

public class ProdutosController {
	
	  @Autowired
	    private ProdutosRepositoryJPA repositoryJPA;
	  
	    @GetMapping(value = "/{id}")
	    public Produtos get(@PathVariable(name = "id") Long id) {
//	    	verificar com o professor Marcos, como usar o null nesse caso.
	        Produtos produto = repositoryJPA.findByProdId(id);
	        return  produto;
	    }

	    @GetMapping
	    public List<Produtos> findAll() {
	        List<Produtos> produtos = repositoryJPA.findAll();
	        return produtos;
	    }

	    @PostMapping
	    public Produtos create(@RequestBody Produtos produto) {
	    	produto = repositoryJPA.save(produto);
	        return produto;
	    }

	    @PutMapping(value = "/{id}")
	    public void update(@PathVariable(name = "id") Long id, @RequestBody Produtos produto) {

	    	produto.setId(id);
	    	produto = repositoryJPA.save(produto);
	    }

	    @DeleteMapping(value = "/{id}")
	    public void remove(@PathVariable(name = "id") Long id) {
	        repositoryJPA.deleteById(id);
	    }

}
