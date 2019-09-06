package com.getulioazevedo.aulasmc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.domain.Produto;
import com.getulioazevedo.aulasmc.repositories.CategoriaRepository;
import com.getulioazevedo.aulasmc.repositories.ProdutoRespository;

@SpringBootApplication
public class AulasmcApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(AulasmcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository cateRepo;	
	@Autowired
	private ProdutoRespository prodRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Notebook Acer Nitro 5",3400.0);
		Produto p2 = new Produto(null,"Mouser", 120.0);
		Produto p3 = new Produto(null,"Impressora", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		cateRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
	}

}
