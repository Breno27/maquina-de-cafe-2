package br.com.cafegoxtoso;

import br.com.cafegoxtoso.domain.Cafe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.cafegoxtoso.domain.CafeController.listaCafes;
import static br.com.cafegoxtoso.domain.CafeController.somaCafesPedido;
import static br.com.cafegoxtoso.domain.Cafe.ordenaCafePorCodigo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaquinaDeCafeConsoleAplicationTest {

    @Test
    void deveListarCafesDisponiveisParaVenda() {
        List<Cafe> listaCafes = new ArrayList<>();
        listaCafes.add(Cafe.AMERICANO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.CAPUCCINO);
        listaCafes.add(Cafe.MACHIATO);
        listaCafes.add(Cafe.LATTE);
        listaCafes.add(Cafe.MOCHA);
        listaCafes.add(Cafe.DESCAFEINADO);
        listaCafes.add(Cafe.CHOCOLATE);

        List<Cafe> cafes = listaCafes();

        assertEquals(listaCafes, cafes);
    }

    @Test
    void deveSomarCafesDeUmPedido() {
        List<Cafe> listaCafes = new ArrayList<>();
        listaCafes.add(Cafe.AMERICANO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.CAPUCCINO);
        listaCafes.add(Cafe.MACHIATO);
        listaCafes.add(Cafe.LATTE);
        listaCafes.add(Cafe.MOCHA);
        listaCafes.add(Cafe.DESCAFEINADO);
        listaCafes.add(Cafe.CHOCOLATE);

        double valorEsperado = 68;

        double resultadoSoma = somaCafesPedido(listaCafes);

        assertEquals(valorEsperado, resultadoSoma);
    }

    @Test
    void deveSomarCafesComDeUmPedidoMesmoQueOCafeSeRepita() {
        List<Cafe> listaCafes = new ArrayList<>();
        listaCafes.add(Cafe.AMERICANO);
        listaCafes.add(Cafe.AMERICANO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.CAPUCCINO);

        double valorEsperado = 41;

        double resultadoSoma = somaCafesPedido(listaCafes);

        assertEquals(valorEsperado, resultadoSoma);
    }

    @Test
    void deveOrdernarCafesPorCodigo() {
        List<Cafe> listaCafes = new ArrayList<>();
        listaCafes.add(Cafe.CAPUCCINO);
        listaCafes.add(Cafe.EXPRESSO);
        listaCafes.add(Cafe.AMERICANO);

        ordenaCafePorCodigo(listaCafes);

        List<Cafe> listaOrdemEsperada = new ArrayList<>();
        listaOrdemEsperada.add(Cafe.AMERICANO);
        listaOrdemEsperada.add(Cafe.EXPRESSO);
        listaOrdemEsperada.add(Cafe.CAPUCCINO);

        assertEquals(listaOrdemEsperada, listaCafes);
    }
}