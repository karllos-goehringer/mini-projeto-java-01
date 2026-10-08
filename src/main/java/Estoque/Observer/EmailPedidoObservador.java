package Estoque.Observer;

import Cliente.Cliente;
import Pedido.Pedido;

import java.util.Objects;

public class EmailPedidoObservador implements ObservadorPedido {
    private final EmailSender emailSender;

    public EmailPedidoObservador(EmailSender emailSender) {
        this.emailSender = Objects.requireNonNull(emailSender, "O serviço de envio de email é obrigatório.");
    }

    @Override
    public void triggerAoCriarPedido(Pedido pedido) {
        Objects.requireNonNull(pedido, "O pedido é obrigatório.");
        Cliente cliente = Objects.requireNonNull(pedido.getCliente(), "O cliente do pedido é obrigatório.");
        String email = cliente.getEmail();
        String assunto = "Compra realizada com sucesso";
        String corpo = "Olá, " + cliente.getNome() + "!\n\n"
                + "Sua compra foi realizada com sucesso.\n"
                + "Valor total do pedido: R$ " + pedido.getValorTotalPedido();

        emailSender.enviar(email, assunto, corpo);
    }
}
