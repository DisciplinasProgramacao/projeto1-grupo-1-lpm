
public class Compromisso {

    private int nDia;
    private String assunto;

    public Compromisso() {

    }

    public Compromisso(int ndia, String assunto) {
        this.nDia = ndia;
        this.assunto = assunto;
    }

    public void imprimeCompromisso(Compromisso atual) {

        Data dt = new Data(atual.getnDia());
        String dtFormat = String.format("%02d", dt.getDia()) + "/" + String.format("%02d", dt.getMes()) + "/"
                + String.format("%4d", dt.getAno());
        System.out.print("Dia: " + atual.getnDia() + " - " + dtFormat + " - " + dt.getDiaSemana());
        System.out.println(" Assunto " + atual.getAssunto());

    }

    public int getnDia() {
        return nDia;
    }

    public void setnDia(int ndia) {
        this.nDia = ndia;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

}