package com.getulioazevedo.aulasmc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository cateRepo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = cateRepo.findById(id);
		return obj.orElse(null);

	}

}
