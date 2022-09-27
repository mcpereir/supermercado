package com.supermercado;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private CupomFiscalRepository cr;
	
	@Autowired
	private ProdutoRepository pr;
	
	@Autowired
	private ItemRepository ir;
	
	@Test
	void contextLoads() {
	}

	//@Test
	void criarProduto() {
		Produto p = new Produto();
		p.setCodigo(1001);
		p.setDescricao("Sabonete");
		p.setValor(2.50);
		pr.save(p);
	}
	
	@Test
	void criarModelTodo() {
		CupomFiscal  cf = new CupomFiscal();
		cf.setCnpj("12345678901234");
		cf.setData(LocalDate.of(2022, 8, 05));
		cf.setHora(LocalDateTime.of(2022, 8, 05, 22, 22));
		cf.setNomeEstabelecimento("Super 111");
		cf.setValorTotal(7.50);
		cr.save(cf);
		
		Produto p = new Produto();
		p.setCodigo(1001);
		p.setDescricao("Sabonete");
		p.setValor(2.50);
		pr.save(p);
		
		Produto p1 = new Produto();
		p1.setCodigo(1002);
		p1.setDescricao("Pasta Dente");
		p1.setValor(2.50);
		pr.save(p1);
		
		Produto p2 = new Produto();
		p2.setCodigo(1003);
		p2.setDescricao("Shampoo");
		p2.setValor(2.50);
		pr.save(p2);
		
		Item i = new Item();
		i.setCupomFiscal(cf);
		i.setProduto(p);
		i.setQtde(3);
		i.setValor(p.getValor()*i.getQtde());
		ir.save(i);
		
		Item i1 = new Item();
		i1.setCupomFiscal(cf);
		i1.setProduto(p1);
		i1.setQtde(1);
		i1.setValor(p1.getValor()*i1.getQtde());
		ir.save(i1);
		
		Item i2 = new Item();
		i2.setCupomFiscal(cf);
		i2.setProduto(p2);
		i2.setQtde(2);
		i2.setValor(p2.getValor()*i2.getQtde());
		ir.save(i2);
		

	}
}
