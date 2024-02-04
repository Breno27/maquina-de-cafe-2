package br.com.cafegoxtoso;

import br.com.cafegoxtoso.domain.Cafe;
import br.com.cafegoxtoso.domain.MensagensAtendimento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaquinaDeCafeConsoleAplication {
    public static void main(String[] args) {
        MensagensAtendimento.INICIO_ATENDIMENTO.printMensagem();

        List<Cafe> cafe = List.of(Cafe.values());
        cafe.forEach(System.out::println);

        List<Cafe> cafesDoPedido = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();

        do {
            try {
                int finalOpcao = opcao;
                Cafe.cafePorCodigo(opcao).ifPresent(cafe1 -> {
                    cafesDoPedido.add(cafe.get(finalOpcao));
                    MensagensAtendimento.PADRAO_ESCOLHAS.printMensagem();
                });

            } catch (Exception e) {
                MensagensAtendimento.PADRAO_ERRO_ESCOLHA.printMensagem();
            }
        } while ((opcao = scan.nextInt()) != 0);

        MensagensAtendimento.FINALIZANDO_PEDIDO.printMensagem();

        cafesDoPedido.sort(Comparator.comparing(Cafe::getCodigo));
        cafesDoPedido.forEach(System.out::println);

        double somaCafesPedido;
        somaCafesPedido = cafesDoPedido.stream()
                .mapToDouble(Cafe::getValor)
                .sum();

        System.out.println("\nTotal: " + somaCafesPedido);
    }
}
