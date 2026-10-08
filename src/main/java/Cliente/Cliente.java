package Cliente;

public class Cliente {
    String nome;
    String categoria;
    String email;
    Boolean primeiraCompra;
    Double saldo;

    public Cliente(String nome, String categoria, Boolean primeiraCompra, Double saldo, String email) {
        this.nome = nome;
        this.categoria = categoria;
        this.primeiraCompra = primeiraCompra;
        this.saldo = saldo;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void addSaldo(Double saldo) {
        this.saldo += saldo;
    }
    public void removeSaldo(Double saldo) {
        this.saldo -= saldo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getPrimeiraCompra() {
        return primeiraCompra;
    }

    public void setPrimeiraCompra(Boolean primeiraCompra) {
        this.primeiraCompra = primeiraCompra;
    }
}
