public class Data {

	private int dia;
	private int mes;
	private int ano;
	private int diaAno;
	private String diaSemana;
	private boolean dataValida=false;

	public Data(int dia, int mes, int ano) {

		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.diaAno = diaAno(dia, mes, ano);
		this.diaSemana = DiaSemana(dia, mes, ano);
		this.dataValida = (dia > 0) ? (true):(false);
		//this.dataValida = (dia == mes == ano > 0) ? (true):(false) ;
	}
	public Data(int diaAno) {
		int[] dataconvert = dataDiaAno(diaAno);
		this.dia = dataconvert[0];
		this.mes = dataconvert[1];
		this.ano = dataconvert[2];
		this.diaAno = diaAno(dia, mes, ano);
		this.diaSemana = DiaSemana(dia, mes, ano);
		this.dataValida = (dia > 0) ? (true):(false);
		//this.dataValida = (dia == mes == ano > 0) ? (true):(false) ;
	}

	public Data() {

	}

	public static int ehBissexto(int ano) {
		int anoBis = 0;
		if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)) {
			anoBis = 1;
		}
		return anoBis;
	}

	public static String DiaSemana(int d, int m, int a) {
		String[] dSemana = { "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira",
				"Sábado" };
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
		if (m < 3)
			a -= 1;
		return dSemana[(a + a / 4 - a / 100 + a / 400 + t[m - 1] + d) % 7];
	}

	public static int diasMes(int mes, int ano) {
		int dMes = 31 - ((mes == 2) ? (3 - ehBissexto(ano)) : (((mes - 1) % 7) % 2));
		return dMes;
	}

	public static int diaAno(int dia, int mes, int ano) {
		int diaAno = 0;

		for (int a = 1; a < ano; a++) {
			for (int m = 1; m <= 12; m++) {
				diaAno += diasMes(m, a);
			}
		}
	//	System.out.println("acum " + diaAno);
		for (int m = 1; m < mes; m++) {
			diaAno += diasMes(m, ano);
		}
		
		diaAno = diaAno + dia;
		return diaAno;
	}

	public static int[] dataDiaAno(int diaAno) {
		int diaAnoTemp = diaAno;
		int mesTemp = 1;
	 int ano = 1;
		
		while (diaAnoTemp - diasMes(mesTemp, ano) > 0) {
			diaAnoTemp = diaAnoTemp - diasMes(mesTemp, ano);
			mesTemp++;
			if (mesTemp > 12) {
				mesTemp = 1;
				ano = ano + 1;
			}
		}

		int[] dataDiaAnoTemp = {diaAnoTemp, mesTemp, ano };

		return dataDiaAnoTemp;
	}

	
	
	public static Data verificaData(String dataEntr) {
		// boolean verData = false;
		int dia = 0;
		int mes = 0;
		int ano = 0;
		Data dataAvaliada = new Data();

		String[] vetDataStr = dataEntr.split("/");
		if (vetDataStr.length == 3) {
			if (ehNumeric(vetDataStr) != false) {
				dia = Integer.parseInt(vetDataStr[0]);
				mes = Integer.parseInt(vetDataStr[1]);
				ano = Integer.parseInt(vetDataStr[2]);
				if (ehValorValido(dia, mes, ano) == true) {
					dataAvaliada.setDia(dia);
					dataAvaliada.setMes(mes);
					dataAvaliada.setAno(ano);
					Data diaAgenda = new Data(dia, mes, ano);
					System.out.println("É uma data válida! ");
					System.out.println(
							"Dia " + diaAgenda.getDia() + "/" + diaAgenda.getMes() + "/" + diaAgenda.getAno());
					System.out.println("Dia semana = " + Data.DiaSemana(dia, mes, ano) + "\n");
					dataAvaliada = diaAgenda;
				}
			}
		}
		return dataAvaliada;
	} //Retorna dia 0 mês 0 ano 0 se inválida.

	public static boolean ehValorValido(int dia, int mes, int ano) {
		boolean vVale = false;
		if (dia > 0 && mes > 0 && ano > 0) {
			if (dia <= diasMes(mes, ano) && mes <= 12 && ano < 10000) {
				vVale = true;
			} else {
				if (dia <= 0 || dia > diasMes(mes, ano)) {
		//			System.out.println("O dia " + dia + " não é valido para o mês " + mes);
		//			System.out.println("O mês " + mes + " tem " + diasMes(mes, ano) + " dias.");
					Agenda.excessaw=Agenda.excessaw+"\"O dia \" + dia + \" não é valido para o mês \" + mes\n" + "O mês " + mes + " tem " + diasMes(mes, ano) + " dias.\n";
				}
				if (mes <= 0 || mes > 12) {
		//			System.out.println("O mês " + mes + " não é valido.");
					Agenda.excessaw=Agenda.excessaw+"O mês " + mes + " não é valido.\n";
				}
				if (ano == 2038) {
		//			System.out.println(
		//					"O ano " + ano + " não é contemplado na avaliação. Problema Y2K38 - Gangnam Style. :-) ");
					Agenda.excessaw=Agenda.excessaw+"O ano " + ano + " não é contemplado na avaliação. Problema Y2K38 - Gangnam Style. :-) \n";
				}
				if (ano > 10000) {
		//			System.out.println("Ano " + ano + " é inválido!");
		//			System.out.println("Os anos pós 10.000 não são avaliados.");
					Agenda.excessaw=Agenda.excessaw+"Ano " + ano + " é inválido!\n";
					Agenda.excessaw=Agenda.excessaw+"Os anos pós 10.000 não são avaliados.\n";
					
				}
			}
		}
		return vVale;
	}

	public static boolean ehNumeric(String[] strData) {
		boolean ehNum = false;
		for (int i = 0; i < strData.length; i++) {
			if (strData[i] != null || !strData[i].equals("")) {
				for (int c = 0; c < strData[i].length(); c++) {
					char caracter = strData[i].charAt(c);
					if (caracter >= '0' && caracter <= '9') {
						ehNum = true;
					} else {
				//		System.out.println("Apenas números no formato DD/MM/AAAA são válidos! ");
						Agenda.excessaw=Agenda.excessaw+"Apenas números no formato DD/MM/AAAA são válidos!\n ";
						ehNum = false;
						return ehNum;
					}
				}
			}
		}
		return ehNum;
	}

	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getDiaAno() {
		return diaAno;
	}

	public void setDiaAno(int diaAno) {
		this.diaAno = diaAno;
	}
	
	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public boolean isDataValida() {
		return dataValida;
	}

	public void setDataValida(boolean dataValida) {
		this.dataValida = dataValida;
	}



	
}
