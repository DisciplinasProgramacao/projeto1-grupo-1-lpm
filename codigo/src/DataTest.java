import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DataTest {

    Data d;

    @Before
    public void Data() {
        d = new Data();
    }

    @Test
    public void testAnoBissexto() {
        assertEquals(1, d.verificaBissexto(2024));
    }

    @Test
    public void testAnoNaoBissexto() {
        assertEquals(0, d.verificaBissexto(2023));
    }

}