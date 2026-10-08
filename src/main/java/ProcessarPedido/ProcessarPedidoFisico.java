package ProcessarPedido;

import CalculadoraDesconto.CalculadoraDesconto;
import Pedido.Pedido;
import Pedido.PedidoFisico;

public class ProcessarPedidoFisico extends ProcessarPedido {
    public ProcessarPedidoFisico(CalculadoraDesconto calculadoraDesconto) {
        super(calculadoraDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido == null || pedido.getProdutos() == null || pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido físico inválido.");
        }

        if (!(pedido instanceof PedidoFisico pedidoFisico)) {
            throw new IllegalArgumentException("Esse processamento só aceita pedidos físicos.");
        }

        if (pedidoFisico.getDistanciaEntrega() == null || pedidoFisico.getDistanciaEntrega() < 0) {
            throw new IllegalArgumentException("Distância de entrega inválida.");
        }
    }

    @Override
    protected Double calcularTotal(Pedido pedido) {
        System.out.println("Saldo inicial: " + pedido.getCliente().getSaldo());
        PedidoFisico pedidoFisico = (PedidoFisico) pedido;
        Double valorPedido = pedido.ValorTotalPedido();
        Double desconto = calculadoraDesconto.calcularDesconto(valorPedido, pedido.getCliente());
        double frete = pedidoFisico.getDistanciaEntrega() * 2.5;
        double valorFinal = valorPedido - desconto + frete;

       // logs
        System.out.println("Pedido físico processado.");
        System.out.println("Valor do pedido: R$ " + valorPedido);
        System.out.println("Desconto aplicado: R$ " + desconto);
        System.out.println("Frete: R$ " + frete);
        System.out.println("Valor final: R$ " + valorFinal);
        //
        return valorFinal;
        }
    }

