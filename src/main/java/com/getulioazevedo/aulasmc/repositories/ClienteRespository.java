package com.getulioazevedo.aulasmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.getulioazevedo.aulasmc.domain.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer>{

}
