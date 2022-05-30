package com.getulioazevedo.aulasmc.repositories;

import com.getulioazevedo.aulasmc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRespository extends JpaRepository<Pedido, Integer>{

}
