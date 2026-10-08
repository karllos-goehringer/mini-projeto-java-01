package Estoque.Observer;

import Pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public interface ObservadorPedido {
    void triggerAoCriarPedido(Pedido pedido);
}

