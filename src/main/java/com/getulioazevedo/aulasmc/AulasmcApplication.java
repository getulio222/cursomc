package com.getulioazevedo.aulasmc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.repositories.CategoriaRepository;

@SpringBootApplication
public class AulasmcApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(AulasmcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		
		
		
	}

}
