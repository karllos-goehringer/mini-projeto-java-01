package Pedido;

import Cliente.Cliente;
import Produto.Produto;

import java.util.List;

public class PedidoVirtual extends Pedido{
    public PedidoVirtual(List<Produto> produtos, Cliente cliente) {
        super(produtos, cliente);
    }
}
