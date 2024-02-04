package br.com.cafegoxtoso;

import br.com.cafegoxtoso.domain.Cafe;
import br.com.cafegoxtoso.domain.MensagensAtendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.cafegoxtoso.domain.Cafe.ordenaCafePorCodigo;
import static br.com.cafegoxtoso.domain.CafeController.listaCafes;
import static br.com.cafegoxtoso.domain.CafeController.somaCafesPedido;


public class MaquinaDeCafeConsoleAplication {
    public static void main(String[] args) {
        MensagensAtendimento.INICIO_ATENDIMENTO.printMensagem();

        List<Cafe> cafes = listaCafes();

        List<Cafe> cafesDoPedido = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();

        do {
            try {
                int finalOpcao = opcao;
                Cafe.cafePorCodigo(finalOpcao).ifPresent(cafe1 -> {
                    cafesDoPedido.add(cafes.get(finalOpcao));
                    MensagensAtendimento.PADRAO_ESCOLHAS.printMensagem();
                });

            } catch (Exception e) {
                MensagensAtendimento.PADRAO_ERRO_ESCOLHA.printMensagem();
            }
        } while ((opcao = scan.nextInt()) != 0);

        MensagensAtendimento.FINALIZANDO_PEDIDO.printMensagem();

        ordenaCafePorCodigo(cafesDoPedido);

        somaCafesPedido(cafesDoPedido);
    }

}
