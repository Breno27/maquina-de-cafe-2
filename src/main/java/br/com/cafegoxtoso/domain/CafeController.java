package br.com.cafegoxtoso.domain;

import java.util.List;

public interface CafeController {

    static List<Cafe> listaCafes() {
        List<Cafe> cafe = List.of(Cafe.values());
        cafe.forEach(System.out::println);
        return cafe;
    }

    static double somaCafesPedido(List<Cafe> cafesDoPedido) {
        double somaCafesPedido;
        somaCafesPedido = cafesDoPedido.stream()
                .mapToDouble(Cafe::getValor)
                .sum();

        System.out.println("\nTotal: " + somaCafesPedido);
        return somaCafesPedido;
    }
}
