package CalculadoraDesconto;

import Cliente.Cliente;

public class CalculadoraClienteOuro implements CalculadoraDesconto {
    @Override
    public Double calcularDesconto(Double totalPedido, Cliente cliente) {
        double desconto = 0.00;
        if(cliente.getCategoria().equals("Ouro")){
             desconto = totalPedido * 0.25;
        }
        return desconto;
    };
}
