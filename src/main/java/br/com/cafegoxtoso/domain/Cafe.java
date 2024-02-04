package br.com.cafegoxtoso.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum Cafe {
    AMERICANO(1, "Americano", 6.0),
    EXPRESSO(2, "Expresso", 7.0),
    CAPUCCINO(3, "Capuccino", 8.0),
    MACHIATO(4, "Machiato", 12.0),
    LATTE(5, "Latte", 8.0),
    MOCHA(6, "Mocha", 12.0),
    DESCAFEINADO(7, "Descafeinado", 8.0),
    CHOCOLATE(8, "Chocolate", 7.0);

    private final int codigo;
    private final String nome;
    private final double valor;

    Cafe(int codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public static Optional<Cafe> cafePorCodigo(int codigoCafe){
        return Stream.of(values()).filter(cafe -> cafe.getCodigo() == codigoCafe).findFirst();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return getCodigo()
                + " " + getNome()
                + " " + getValor();
    }
}
