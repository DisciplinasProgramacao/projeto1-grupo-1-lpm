

public class DataTest {

    Data d;

    @Before
    public void Data() {
        d = new Data();
    }

    @Test
    public void testAnoBissexto() {
        assertEquals(true, d.verificaBissexto(2024));
    }

    @Test
    public void testAnoNaoBissexto() {
        assertEquals(false, d.verificaBissexto(2023));
    }

}