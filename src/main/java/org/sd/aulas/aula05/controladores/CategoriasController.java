package org.sd.aulas.aula05.controladores;

import java.util.List;

import org.sd.aulas.aula05.entidades.Categorias;
import org.sd.aulas.aula05.repositorios.CategoriasRepositoryJPA;
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
@RequestMapping("/categorias")
public class CategoriasController {
	
	
	  @Autowired
	    private CategoriasRepositoryJPA repositoryJPA;
	  
	    @GetMapping(value = "/{id}")
	    public Categorias get(@PathVariable(name = "id") Long id) {
//	    	verificar com o professor Marcos, como usar o null nesse caso.
	    	Categorias categoria = repositoryJPA.findByCategId(id);
	        return  categoria;
	    }

	    @GetMapping
	    public List<Categorias> findAll() {
	        List<Categorias> categorias = repositoryJPA.findAll();
	        return categorias;
	    }

	    @PostMapping
	    public Categorias create(@RequestBody Categorias categorias) {
	    	categorias = repositoryJPA.save(categorias);
	        return categorias;
	    }

	    @PutMapping(value = "/{id}")
	    public void update(@PathVariable(name = "id") Long id, @RequestBody Categorias categoria) {

	    	categoria.setId(id);
	    	categoria = repositoryJPA.save(categoria);
	    }

	    @DeleteMapping(value = "/{id}")
	    public void remove(@PathVariable(name = "id") Long id) {
	        repositoryJPA.deleteById(id);
	    }
	

}
