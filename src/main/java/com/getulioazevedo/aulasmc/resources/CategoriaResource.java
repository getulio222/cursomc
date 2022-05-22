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
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarCategoria(@PathVariable Integer id) {
		Categoria objCate = service.buscarCateId(id);
		return ResponseEntity.ok().body(objCate);

	}

}

