package com.getulioazevedo.aulasmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.getulioazevedo.aulasmc.domain.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Integer>{

}
