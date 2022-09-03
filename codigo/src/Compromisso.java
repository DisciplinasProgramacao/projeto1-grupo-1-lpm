
public class Compromisso {
	private int nDia;
	private String assunto;

	public Compromisso() {

	}

	public Compromisso(int ndia, String assunto) {
		this.nDia = ndia;
		this.assunto = assunto;

	}

	public static Compromisso[] criaLoteCompromissos(int ndia, String assunto, int recorrente, int intevalo) {
		Compromisso[] LoteCompromissos = new Compromisso[recorrente];
		
		for (int i = 0; i < recorrente; i++) {
			LoteCompromissos[i] = new Compromisso(ndia + (i * intevalo), i + 1 + "/" + recorrente + "_" + assunto); //

		}
		return LoteCompromissos;
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