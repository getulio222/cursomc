package com.getulioazevedo.aulasmc.services;


import com.getulioazevedo.aulasmc.domain.Cliente;
import com.getulioazevedo.aulasmc.repositories.ClienteRepository;
import com.getulioazevedo.aulasmc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clieRepo;

    public Cliente buscarClienteId(Integer id){
        Optional<Cliente> objCli = clieRepo.findById(id);
      return objCli.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! : " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
