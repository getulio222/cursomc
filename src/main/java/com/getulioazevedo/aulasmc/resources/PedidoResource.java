package com.getulioazevedo.aulasmc.resources;


import com.getulioazevedo.aulasmc.domain.Cliente;
import com.getulioazevedo.aulasmc.domain.Pedido;
import com.getulioazevedo.aulasmc.services.ClienteService;
import com.getulioazevedo.aulasmc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService PediServ;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPedido(@PathVariable Integer id){
        Pedido objCli = PediServ.buscarPedidoId(id);
        return ResponseEntity.ok().body(objCli);
    }
}
