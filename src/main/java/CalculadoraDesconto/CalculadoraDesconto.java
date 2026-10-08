package CalculadoraDesconto;

import Cliente.Cliente;

public interface CalculadoraDesconto {
    Double calcularDesconto(Double totalPedido, Cliente cliente);
}
