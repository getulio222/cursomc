package com.getulioazevedo.aulasmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getulioazevedo.aulasmc.domain.Produto;
import com.getulioazevedo.aulasmc.repositories.ProdutoRespository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRespository prodRepo;

	public Produto buscarProdID(Integer id) {
		Optional<Produto> objProd = prodRepo.findById(id);
		return objProd.orElse(null);

	}

}
