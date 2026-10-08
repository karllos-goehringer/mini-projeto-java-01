package ProcessarPedido;

import CalculadoraDesconto.CalculadoraDesconto;
import Cliente.Cliente;
import Estoque.Observer.ObservadorPedido;
import Pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessarPedido {
    protected final CalculadoraDesconto calculadoraDesconto;

    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public ProcessarPedido(CalculadoraDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public void registrarObservador(ObservadorPedido observador) {
        this.observadores.add(observador);
    }

    public void removerObservador(ObservadorPedido observador) {
        this.observadores.remove(observador);
    }

    public void descontarSaldoCliente(Double valorTotalPedido, Cliente cliente) {
        cliente.removeSaldo(valorTotalPedido);
        System.out.println("Saldo final cliente: " + cliente.getSaldo());
    }

    public final void processar(Pedido pedido) {
        validar(pedido);
        Double totalPedido = calcularTotal(pedido);
        descontarSaldoCliente(totalPedido, pedido.getCliente());
        notificar(pedido);
        System.out.println("\n \n Fim do processamento de pedido! \n------------------------------------\n\n");
        //ajuste jagi
    }
    protected abstract void validar(Pedido pedido);
    protected abstract Double calcularTotal(Pedido pedido);

    protected void notificar(Pedido pedido) {
        for (ObservadorPedido observador : observadores) {
            observador.triggerAoCriarPedido(pedido);
        }
    }
}