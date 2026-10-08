package CalculadoraDesconto;

import Cliente.Cliente;
import java.util.List;

public class CalculadoraDescontoComposite implements CalculadoraDesconto {
    private final List<CalculadoraDesconto> calculadoras;

    public CalculadoraDescontoComposite(List<CalculadoraDesconto> calculadoras) {
        this.calculadoras = calculadoras;
    }

    @Override
    public Double calcularDesconto(Double totalPedido, Cliente cliente) {
        Double descontoTotal = 0.0;
        for (CalculadoraDesconto calculadora : calculadoras) {
            descontoTotal += calculadora.calcularDesconto(totalPedido, cliente);
        }

        return descontoTotal;
    }

}
