package org.example;

import CalculadoraDesconto.CalculadoraClienteOuro;
import CalculadoraDesconto.CalculadoraDescontoComposite;
import CalculadoraDesconto.CalculadoraPrimeiraCompra;
import Cliente.Cliente;
import Estoque.EstoqueProdutos;
import Estoque.Observer.BaixaEstoqueObservador;
import Estoque.Observer.ConsoleEmailSender;
import Estoque.Observer.EmailPedidoObservador;
import Pedido.PedidoFisico;
import Pedido.PedidoVirtual;
import ProcessarPedido.ProcessarPedido;
import ProcessarPedido.ProcessarPedidoFisico;
import ProcessarPedido.ProcessarPedidoVirtual;
import Produto.Produto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria Silva", "Ouro", true, 1000.0, "maria@example.com");
        CalculadoraDescontoComposite calculadoraDesconto = new CalculadoraDescontoComposite(
                Arrays.asList(new CalculadoraPrimeiraCompra(), new CalculadoraClienteOuro())
        );

        Produto camisa = new Produto("Nike", "Camisa", 120.0);
        Produto tenis = new Produto("Adidas", "Tênis", 260.0);
        Produto calca = new Produto("NB","Jeans",80.00);

        List<Produto> produtosFisicos = new ArrayList<>(Arrays.asList(camisa, tenis));
        PedidoFisico pedidoFisico = new PedidoFisico(produtosFisicos, cliente, 25.0);

        EstoqueProdutos estoqueFisico = new EstoqueProdutos(new ArrayList<>(produtosFisicos));
        estoqueFisico.addProduto(calca);
        BaixaEstoqueObservador baixaEstoqueFisico = new BaixaEstoqueObservador(estoqueFisico);
        ProcessarPedido processadorFisico = new ProcessarPedidoFisico(calculadoraDesconto);
        processadorFisico.registrarObservador(baixaEstoqueFisico);
        processadorFisico.registrarObservador(new EmailPedidoObservador(new ConsoleEmailSender()));
        processadorFisico.processar(pedidoFisico);

        System.out.println("Itens restantes no estoque físico: " + estoqueFisico.totalItensEstoque());

        Produto ebook = new Produto("Amazon", "Ebook", 99.0);
        Produto giftCard = new Produto("AppStore", "Gift Card", 200.00);
        PedidoVirtual pedidoVirtual = new PedidoVirtual(new ArrayList<>(List.of(ebook)), cliente);
        ProcessarPedido processadorVirtual = new ProcessarPedidoVirtual(calculadoraDesconto);
        processadorVirtual.registrarObservador(new EmailPedidoObservador(new ConsoleEmailSender()));
        processadorVirtual.processar(pedidoVirtual);

    }
}
