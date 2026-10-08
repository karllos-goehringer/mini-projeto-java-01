package CalculadoraDesconto;

import Cliente.Cliente;

public class CalculadoraClienteComum implements CalculadoraDesconto {
    @Override
    public Double calcularDesconto(Double totalPedido,Cliente cliente) {
           return totalPedido * 0.01;
    }

}
