package ProcessarPedido;

import CalculadoraDesconto.CalculadoraDesconto;
import Pedido.Pedido;
import Pedido.PedidoVirtual;

public class ProcessarPedidoVirtual extends ProcessarPedido {
    public ProcessarPedidoVirtual(CalculadoraDesconto calculadoraDesconto) {
        super(calculadoraDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido == null || pedido.getProdutos() == null || pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido virtual inválido.");
        }

        if (!(pedido instanceof PedidoVirtual)) {
            throw new IllegalArgumentException("Esse processamento só aceita pedidos virtuais.");
        }
    }

    @Override
    protected Double calcularTotal(Pedido pedido) {
        System.out.println("Saldo inicial: " + pedido.getCliente().getSaldo());
        Double valorPedido = pedido.ValorTotalPedido();
        Double desconto = calculadoraDesconto.calcularDesconto(valorPedido, pedido.getCliente());
        double frete = 0.0;
        double valorFinal = valorPedido - desconto + frete;
     //
        System.out.println("Pedido virtual processado.");
        System.out.println("Valor do pedido: R$ " + valorPedido);
        System.out.println("Desconto aplicado: R$ " + desconto);
        System.out.println("Frete: R$ " + frete);
        System.out.println("Valor final: R$ " + valorFinal);
      //
        return valorFinal;
    }
}
