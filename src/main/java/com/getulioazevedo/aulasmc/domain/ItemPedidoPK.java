package com.getulioazevedo.aulasmc.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/*Classe criada para cumprir a função de relacionamento composto entre Pedido > ItemPedido < Produto  (Ver o PDF da Modelagem) */

@Embeddable // Para informar ao JPA que essa classe é um subtipo.
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;

   @ManyToOne
   @JoinColumn(name = "pedido_id") // Será a chave estrangeira no banco
   private Pedido pedido;

   @ManyToOne
   @JoinColumn(name = "produto_id") // Será a chave estrangeira no banco
   private Produto produto;


    //Getter and Setter

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    //


    // Hash Code and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }
}
