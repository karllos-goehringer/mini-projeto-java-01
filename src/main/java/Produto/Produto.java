package Produto;

import Cliente.Cliente;
    public class Produto {
        final String marca;
        final String modelo;
        final Double valor;

        public Produto(String marca, String modelo, Double valor) {
            this.marca = marca;
            this.modelo = modelo;
            this.valor = valor;
        }

        public String getMarca() {
            return marca;
        }
        public String getModelo() {
            return modelo;
        }
        public Double getValor() {
            return valor;
        }
    }


