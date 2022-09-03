import java.util.ArrayList;

public class Agenda {
	private ArrayList<Compromisso> agenda = new ArrayList<Compromisso>();
	private int compReg = 0;

/*	public Agenda(Compromisso[] compromissos) {
		for (Compromisso com : compromissos) {
			this.compReg++;
			this.agenda.add(com);
		}
	}
*/
	public Agenda() {

	}

	public ArrayList<Compromisso> getAgenda() {
		return agenda;
	}

	public void setAgenda(Compromisso[] compromissos) {
		for (Compromisso com : compromissos) {
			this.compReg++;
			this.agenda.add(com);
		}
		
	}

	public int getCompReg() {
		return compReg;
	}

	public void setCompReg(int compReg) {
		this.compReg = compReg;
	}

}