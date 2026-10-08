package Pedido;

import Cliente.Cliente;
import Produto.Produto;

import java.util.List;

public class PedidoFisico extends Pedido{
    Double distanciaEntregaKM;
    public PedidoFisico(List<Produto> produtos, Cliente cliente, Double distanciaEntregaKM) {
        super(produtos, cliente);
        this.distanciaEntregaKM = distanciaEntregaKM;
    }

    public Double getDistanciaEntrega() {
        return distanciaEntregaKM;
    }

}
