package Estoque.Observer;

import Pedido.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    public void registrar(ObservadorPedido obs) {
        observadores.add(obs);
    }
    public void criar(Pedido pedido) {
        observadores.forEach(obs -> obs.triggerAoCriarPedido(pedido));
    }
}
