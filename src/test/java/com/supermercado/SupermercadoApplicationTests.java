package com.supermercado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.supermercado.model.CupomFiscal;
import com.supermercado.model.Item;
import com.supermercado.model.Produto;
import com.supermercado.repository.CupomFiscalRepository;
import com.supermercado.repository.ItemRepository;
import com.supermercado.repository.ProdutoRepository;

@SpringBootTest
class SupermercadoApplicationTests {

	@Autowired
	private CupomFiscalRepository cupomFiscalRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	void contextLoads() {
	}

	//@Test
	void criarProduto() {
		Produto p = new Produto();
		p.setCodigo(1001);
		p.setDescricao("Sabonete");
		p.setValor(2.50);
		produtoRepository.save(p);
	}
	
	//@Test
	void criarModelTodo() {
		CupomFiscal  cf = new CupomFiscal();
		cf.setCnpj("12345678901234");
		cf.setData(LocalDate.of(2022, 8, 05));
		cf.setHora(LocalDateTime.of(2022, 8, 05, 22, 22));
		cf.setNomeEstabelecimento("Super 111");
		cf.setValorTotal(7.50);
		cupomFiscalRepository.save(cf);
		
		Produto p = new Produto();
		p.setCodigo(1001);
		p.setDescricao("Sabonete");
		p.setValor(2.50);
		produtoRepository.save(p);
		
		Produto p1 = new Produto();
		p1.setCodigo(1002);
		p1.setDescricao("Pasta Dente");
		p1.setValor(2.50);
		produtoRepository.save(p1);
		
		Produto p2 = new Produto();
		p2.setCodigo(1003);
		p2.setDescricao("Shampoo");
		p2.setValor(2.50);
		produtoRepository.save(p2);
		
		Item i = new Item();
		i.setCupomFiscal(cf);
		i.setProduto(p);
		i.setQtde(3);
		i.setValor(p.getValor()*i.getQtde());
		itemRepository.save(i);
		
		Item i1 = new Item();
		i1.setCupomFiscal(cf);
		i1.setProduto(p1);
		i1.setQtde(1);
		i1.setValor(p1.getValor()*i1.getQtde());
		itemRepository.save(i1);
		
		Item i2 = new Item();
		i2.setCupomFiscal(cf);
		i2.setProduto(p2);
		i2.setQtde(2);
		i2.setValor(p2.getValor()*i2.getQtde());
		itemRepository.save(i2);
		

	}
	@Test
	void select() {
		// SELECT DE REPOSITORY
				Optional<CupomFiscal> optional = cupomFiscalRepository.findById(1);
				
				// https://zetcode.com/springboot/findbyid/
				// https://www.netsurfingzone.com/jpa/spring-data-jpa-crudrepository-finbyid/
				var val = cupomFiscalRepository.findById(1);
				// or
				CupomFiscal cupomFiscal = optional.get();
				System.out.println("val:" + val.get().getNomeEstabelecimento());
				System.out.println("object:" + cupomFiscal.getNomeEstabelecimento() + "\n");
				
				// SELECTS POR ASSOCIAÇÃO DE OBJETOS
				/*
				for (CupomFiscal cf : cupomFiscalRepository.findAll()) {
					System.out.println("cada cf..." + cf.getNomeEstabelecimento());
					for(Item item : cf.getItens()) {
						System.out.println("   com seu item..." + item.getId());
						System.out.println("   ao produto..." + item.getProduto().getDescricao());
					}
					if(cf.getItens().size() == 0) {
						System.out.println("   sem itens...");
					}
				}			
				*/
				for (Item item : val.get().getItens()) {
					System.out.println("\nItens do Cupom Fiscal " + val.get().getId() + ": " + item.getQtde() + " " + item.getProduto().getDescricao() + "\n");
				}		
				
				// SELECT DE REPOSITORY (MAIS OPÇÕES)
				Produto p1 = produtoRepository.findByDescricao("Sabonete");
				System.out.println("produto : " + p1.getCodigo());
				
				List<Produto> produtos1 = produtoRepository.findByDescricaoContaining("S");
				for (Produto produto : produtos1) {
					System.out.println("produtos : " + produto.getDescricao());	
				}
				
				Produto prod = produtoRepository.findByCodigo(333);
				System.out.println("valor : " + prod.getValor());
	}
}
