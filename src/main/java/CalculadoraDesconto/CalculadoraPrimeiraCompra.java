package CalculadoraDesconto;

import Cliente.Cliente;

public class CalculadoraPrimeiraCompra implements CalculadoraDesconto{
    @Override
    public Double calcularDesconto(Double totalPedido, Cliente cliente) {
        Double desconto = 0.00;
        if(cliente.getPrimeiraCompra() == true) {
            desconto = totalPedido * 0.15;
        }
        return desconto;
    }
}

