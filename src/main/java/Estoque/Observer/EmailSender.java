package Estoque.Observer;

public interface EmailSender {
    void enviar(String destinatario, String assunto, String corpo);
}
