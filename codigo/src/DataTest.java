import org.junit.jupiter.api.Test;

public class DataTest {
    
    @Test
    public void construtorSimple() {
        Data dataTeste = new Data();
        assertEquals("01/01/1990", dataTeste.dataFormatada(), "Data padrão criada");
    }

    @Test
    public void construtorComAnoFixo() {
        Data dataTeste = new Data(17, 08);
        assertEquals("17/08/2022", dataTeste.dataFormatada())
    }

    
}
