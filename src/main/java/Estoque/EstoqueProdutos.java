package Estoque;

import Produto.Produto;

import java.util.List;

public class EstoqueProdutos {
    List<Produto> produtos;
    public EstoqueProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public int totalItensEstoque() {
        return this.produtos.size();
    }
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }
}
