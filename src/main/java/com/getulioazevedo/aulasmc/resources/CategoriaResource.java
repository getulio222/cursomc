package com.getulioazevedo.aulasmc.resources;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.services.CategoriaService;

/* AULA DE MODELAGEM CONCEITUAL */

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)	
	public ResponseEntity<?> find(@PathVariable Integer id ) { /*Para que o a variavel do metodo find() receba o id do endpoint(id), colocar a anotacao @PathVariable */		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}	



}
