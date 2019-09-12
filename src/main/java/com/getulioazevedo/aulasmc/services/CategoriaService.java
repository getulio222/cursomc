package com.getulioazevedo.aulasmc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getulioazevedo.aulasmc.domain.Categoria;
import com.getulioazevedo.aulasmc.repositories.CategoriaRepository;
import com.getulioazevedo.aulasmc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository cateRepo;
	
	public Categoria buscarCateId(Integer id) {
		Optional<Categoria> obj = cateRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! : " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
