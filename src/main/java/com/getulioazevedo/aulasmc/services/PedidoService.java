package com.getulioazevedo.aulasmc.services;


import com.getulioazevedo.aulasmc.domain.Cliente;
import com.getulioazevedo.aulasmc.domain.Pedido;
import com.getulioazevedo.aulasmc.repositories.ClienteRepository;
import com.getulioazevedo.aulasmc.repositories.PedidoRespository;
import com.getulioazevedo.aulasmc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRespository PediRepo;

    public Pedido buscarPedidoId(Integer id){
        Optional<Pedido> objCli = PediRepo.findById(id);
      return objCli.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! : " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
