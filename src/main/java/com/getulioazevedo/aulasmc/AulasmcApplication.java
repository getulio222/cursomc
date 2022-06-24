package com.getulioazevedo.aulasmc;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.getulioazevedo.aulasmc.domain.*;
import com.getulioazevedo.aulasmc.domain.enums.EstadoPagamento;
import com.getulioazevedo.aulasmc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.getulioazevedo.aulasmc.domain.enums.TipoCliente;

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

	@Autowired
	private PedidoRespository pedRepo;

	@Autowired
	private PagamentoRespository pagRepo;

	@Autowired
	private ItemPedidoRepository itemRepo;
	
	
	@Override
	public void run(String... args) throws Exception {

		//Categorias
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		//

		//Produtos
		Produto prod1 = new Produto(null,"Notebook Acer Nitro 5",3400.0);
		Produto prod2 = new Produto(null,"Mouser", 120.0);
		Produto prod3 = new Produto(null,"Impressora", 80.0);



		//

		//Categorias e Produtos
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod3));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		cateRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));

		//


		//Estados
		Estado est1 = new Estado(null,"Pernambuco");
		Estado est2 = new Estado(null,"São Paulo");
		//


		//Cidade
		Cidade c1 = new Cidade(null,"Recife",est1);
		Cidade c2 = new Cidade(null,"Campinas",est2);
		Cidade c3 = new Cidade(null,"São Paulo",est2);
		//

		//Estados e Cidades
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estRepo.saveAll(Arrays.asList(est1,est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));

		//


		//Clientes
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","00011122233",TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("992378955","995256080"));
		//

		//Endereços
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303","Jardim","38220384",cli1, c1);
		
		Endereco e2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","355959",cli1,c2);
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));

		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1,e2));

		//

		//Necessario criar um objeto para data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm" );

		//Pedidos

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2022 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2022 19:35"), cli1, e2);

		//Pagamentos

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2022 00:00")
				, null);
		ped2.setPagamento(pagto2);

		//Associações
		cli1.getPedido().addAll(Arrays.asList(ped1, ped2));

		pedRepo.saveAll(Arrays.asList(ped1,ped2));
		pagRepo.saveAll(Arrays.asList(pagto1,pagto2));

		//Item Pedidos

		ItemPedido ip1 = new ItemPedido(ped1, prod1, 0.00,1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, prod3, 0.00, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, prod2,100.0, 1, 800.0);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));


		itemRepo.saveAll(Arrays.asList(ip1,ip2,ip3));

	}

}
