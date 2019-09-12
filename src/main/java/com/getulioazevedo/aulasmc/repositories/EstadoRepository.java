package com.getulioazevedo.aulasmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.getulioazevedo.aulasmc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{ 

}
