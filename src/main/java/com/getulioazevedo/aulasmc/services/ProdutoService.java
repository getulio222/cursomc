package com.getulioazevedo.aulasmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getulioazevedo.aulasmc.domain.Produto;
import com.getulioazevedo.aulasmc.repositories.ProdutoRespository;
import com.getulioazevedo.aulasmc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRespository prodRepo;

	public Produto buscarProdId(Integer id) {
		Optional<Produto> objProd = prodRepo.findById(id);
		return objProd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! :"+ id + ", Tipo: " + Produto.class.getName()));
	}
}
