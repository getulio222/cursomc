package com.getulioazevedo.aulasmc.resources;


import com.getulioazevedo.aulasmc.domain.Cliente;
import com.getulioazevedo.aulasmc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService cliServ;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarCliente(@PathVariable Integer id){
        Cliente objCli = cliServ.buscarClienteId(id);
        return ResponseEntity.ok().body(objCli);
    };
}
