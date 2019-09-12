package com.getulioazevedo.aulasmc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.services.CategoriaService;



@RestController
@RequestMapping(value = "/categorias") // EndPonint da Classe
public class CategoriaResource {

	@Autowired
	private CategoriaService service; // Dependencia do Serviço

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // EndPoint do Metodo
	public ResponseEntity<?> buscarCategoria(@PathVariable Integer id) {
		Categoria objCate = service.buscarCateId(id); // Objeto estanciado recebendo o metodo de busca do Service
		return ResponseEntity.ok().body(objCate);

	}

}

/*
 * Anotações: As Classe do tipo Resources recebem as anotações do @RestControle
 * e os EndPoints.
 * -----------------------------------------------------------------------------
 * Sempre os metodos da classe que vai gerar o Rest tem que ter metodos pequenos.
 * É necessario criar a dependencia do Service, junto com @Autowired.
 * Mapear a classe e os Metodos, criando assim os EndPoints (@RequestMapping).
 * Colocar o Caminho do variavel que vai receber o ID da resposta (@PathVariable) 
 * Criar a estanciação da classe e gerar o objeto recebendo as propriedades da Classe Service.
 * Criar a logica do Retorno do metodo recebendo o tipo ReponsyEntity o status ok() 
 * e no corpo body(), o objeto.
 */