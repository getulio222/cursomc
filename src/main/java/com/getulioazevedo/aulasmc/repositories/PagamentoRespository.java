package com.getulioazevedo.aulasmc.repositories;

import com.getulioazevedo.aulasmc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRespository extends JpaRepository<Pagamento, Integer>{

}
