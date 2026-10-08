package Estoque.Observer;

import Estoque.EstoqueProdutos;
import Pedido.Pedido;
import Produto.Produto;

public class BaixaEstoqueObservador implements ObservadorPedido {
    private final EstoqueProdutos estoque;

    public BaixaEstoqueObservador(EstoqueProdutos estoque) {
        this.estoque = estoque;
    }

    @Override
    public void triggerAoCriarPedido(Pedido pedido) {
        for (Produto produto : pedido.getProdutos()) {
            this.estoque.removeProduto(produto);
        }
        System.out.println("Baixa no estoque realizada para o pedido: " + pedido.hashCode());
    }
}