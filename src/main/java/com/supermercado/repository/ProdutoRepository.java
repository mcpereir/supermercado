package com.supermercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supermercado.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	public Produto findByDescricao(String descricao);
	public List<Produto> findByDescricaoContaining(String descricao);
	public Produto findByCodigo(Integer cod);
	
	@Query("SELECT p FROM Produto p where p.descricao = :descricao")
    public Produto findByDescription(@Param("description") String descricao);
	
	
/*	
	@Query(value= "select 	cp., cs. "
			+ "from		calendario_profissional cp "

			+ "		INNER JOIN calendario_servico cs ON "
			+ "				cp.servico 		= cs.servico and "
			+ "				cp.data 		= cs.data and "
			+ "				cp.hora_inicial = cs.hora_inicial and "
			+ "				cp.hora_final 	= cs.hora_final "

			+ "where	cp.servico = ?1 and "
			+ "			cp.data = ?2 "
			, nativeQuery = true ) 
     List<CalendarioProfissional> findServicoData(Servico servico, LocalDate data);
*/
}
