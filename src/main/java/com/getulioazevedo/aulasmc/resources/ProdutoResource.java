package com.getulioazevedo.aulasmc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.getulioazevedo.aulasmc.domain.Produto;
import com.getulioazevedo.aulasmc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService prodServ;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> buscarProduto(@PathVariable Integer id){		
		Produto objProd = prodServ.buscarProdId(id);
		return ResponseEntity.ok().body(objProd);
		
	}
}

