package com.getulioazevedo.aulasmc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.domain.Cidade;
import com.getulioazevedo.aulasmc.domain.Cliente;
import com.getulioazevedo.aulasmc.domain.Endereco;
import com.getulioazevedo.aulasmc.domain.Estado;
import com.getulioazevedo.aulasmc.domain.Produto;
import com.getulioazevedo.aulasmc.domain.enums.TipoCliente;
import com.getulioazevedo.aulasmc.repositories.CategoriaRepository;
import com.getulioazevedo.aulasmc.repositories.CidadeRepository;
import com.getulioazevedo.aulasmc.repositories.ClienteRespository;
import com.getulioazevedo.aulasmc.repositories.EnderecoRepository;
import com.getulioazevedo.aulasmc.repositories.EstadoRepository;
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
	@Autowired
	private EstadoRepository estRepo;
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private ClienteRespository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;
	
	
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
		
		Estado est1 = new Estado(null,"Pernambuco");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Recife",est1);
		Cidade c2 = new Cidade(null,"Campinas",est2);
		Cidade c3 = new Cidade(null,"São Paulo",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));	
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","00011122233",TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("992378955","995256080"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303","Jardim","38220384",cli1, c1);
		
		Endereco e2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","355959",cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		
		
		
		estRepo.saveAll(Arrays.asList(est1,est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		cateRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1,e2));
		
		
		
	}

}
