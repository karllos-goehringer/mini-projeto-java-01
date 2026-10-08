package Pedido;

import Cliente.Cliente;
import Produto.Produto;

import java.util.List;

public class Pedido {
    List<Produto> produtos;
    Cliente cliente;
    public Pedido(List<Produto> produtos, Cliente cliente) {
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double ValorTotalPedido(){
        Double valorTotal = 0.0;
        for (Produto produto : produtos) {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }

    public Double getValorTotalPedido() {
        return ValorTotalPedido();
    }

}