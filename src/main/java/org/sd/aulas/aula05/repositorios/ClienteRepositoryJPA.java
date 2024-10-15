package org.sd.aulas.aula05.repositorios;

import org.sd.aulas.aula05.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//PARA FIXAR MELHOR O CONTEÚDO: 
//import org.sd.aulas.aula05.entidades.Cliente;: Importa a classe Cliente, representa uma entidade do seu banco de dados.
// import org.springframework.data.jpa.repository.JpaRepository;: Importa a interface JpaRepository, que fornece métodos prontos para operações de CRUD (Create, Read, Update, Delete)
// import org.springframework.data.jpa.repository.Query;: Importa a anotação @Query, que permite escrever consultas personalizadas usando JPQL ou SQL.
//import org.springframework.stereotype.Repository;: Importa a anotação @Repository, que indica que a interface é um repositório Spring, facilitando a injeção de dependência.

/*
@Repository: Indica que esta interface é um componente Spring que gerencia a persistência de dados. O Spring pode detectar e registrar automaticamente este repositório.

public interface ClienteRepositoryJPA: Declara uma interface chamada ClienteRepositoryJPA.

extends JpaRepository<Cliente, Long>: A interface estende JpaRepository, onde:

    Cliente é o tipo da entidade que será gerenciada.
    Long é o tipo da chave primária da entidade Cliente.
*/

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {
	
//	@Query(...): Essa anotação permite definir uma consulta JPQL (Java Persistence Query Language) personalizada.
//	select cli from Cliente cli where cli.cpf = ?1: Esta consulta busca um cliente (cli) onde o CPF (cpf) é igual ao valor fornecido. O ?1 representa o primeiro parâmetro do método (neste caso, cpf).
	

    @Query("select cli from Cliente cli where cli.cpf = ?1")
    public Cliente findByCpf(String cpf);
}
