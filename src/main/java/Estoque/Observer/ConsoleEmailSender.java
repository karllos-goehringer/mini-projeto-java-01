package Estoque.Observer;

public class ConsoleEmailSender implements EmailSender {
    @Override
    public void enviar(String destinatario, String assunto, String corpo) {
        System.out.println("Email enviado para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println(corpo);
    }
}
