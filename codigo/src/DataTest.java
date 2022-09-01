import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataTest {

    Data d;

    @BeforeEach
    public void Data() {
        d = new Data();
    }

    @Test
    public void testAnoBissexto() {
        assertEquals(true, d.verificaBissexto(2024), "Verifica ano bissexto");
    }

    @Test
    public void testAnoNaoBissexto() {
        assertEquals(false, d.verificaBissexto(2023), "Verifica ano não bissexto");
    }

    @Test
    public void testDataValida() {
        assertEquals(true, Data.ehValorValido(10, 02, 2020), "Data válida");
    }

    @Test
    public void testDataNaoValida() {
        assertEquals(false, Data.ehValorValido(10, 02, 2020), "Data válida");
    }

}
