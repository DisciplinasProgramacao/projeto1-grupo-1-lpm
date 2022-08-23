import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

	static ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
	static String excessaw = "";

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner obj = new Scanner(System.in);
		// Runtime.getRuntime().exec("clear");

		System.out.println("\nAGENDA COMPROMISSOS\n");

		System.out.println("1 - Criar compromisso em datas espec�ficas.");
		System.out.println("2 - Cadastrar compromissos peri�dicos:");
		System.out.println("3 - Fornecer relat�rio de compromissos entre datas.");
		System.out.println("Entre com o n�mero correspondente � fun��o da Agenda: ou f para sair:");
		System.out.println("\n");
		opcoes(obj.nextLine());
		obj.close();
	}

	public static void opcoes(String opcao) {
		Scanner obj = new Scanner(System.in);
		Data dtValida = new Data();
		switch (opcao) {

			case "1":
				System.out.println("Criar Compromisso:");
				System.out.println("Entre com uma data no formato DD/MM/AAAA: ");
				dtValida = Data.verificaData(obj.nextLine());

				if (dtValida.isDataValida() == true) {
					criarCompromisso(dtValida);
					for (Compromisso comp : compromissos) {
						if (comp.getnDia() == dtValida.getDiaAno()) {
							System.out.print("Compromisso:");
							comp.imprimeCompromisso(comp);
						}
						menu();
					}
				} else {
					System.out.println(excessaw);
					System.out.println("Digite 'Enter' para continuar...\n");
					opcoes(obj.nextLine());
				}
				break;
			case "2":
				System.out.println("Cadastrar compromissos peri�dicos");
				System.out.println("Entre com uma data no formato DD/MM/AAAA: ");
				dtValida = Data.verificaData(obj.nextLine());
				if (dtValida.isDataValida() == true) {
					criarCompromissoPeriodico(dtValida);
					menu();
				} else {
					System.out.println(excessaw);
					System.out.println("Digite 'Enter' para continuar...\n");
					opcoes(obj.nextLine());
				}
				break;
			case "3":
				System.out.println("Fornecer relat�rio de compromissos entre datas:");
				Data dtInicial = new Data();
				Data dtFinal = new Data();
				System.out.println("Entre com data inicial no formato DD/MM/AAAA: ");
				dtInicial = Data.verificaData(obj.nextLine());
				System.out.println("Entre com data final no formato DD/MM/AAAA: ");
				dtFinal = Data.verificaData(obj.nextLine());

				if (dtInicial.isDataValida() && dtFinal.isDataValida() && dtInicial.getDiaAno() < dtFinal.getDiaAno()) {
					for (Compromisso comp : compromissos) {
						if (comp.getnDia() >= dtInicial.getDiaAno() && comp.getnDia() <= dtFinal.getDiaAno()) {
							comp.imprimeCompromisso(comp);
						} else {
							System.out.println(excessaw);
							System.out.println("Digite 'Enter' para continuar...\n");
							opcoes(obj.nextLine());
						}

					}
				}

				break;
			case "F":
				teste();
				break;
			default:
				System.out.println("op��o invalida!");
				menu();
		}
		obj.close();
	}

	public static void criarCompromisso(Data dataVerificada) {
		Scanner obj = new Scanner(System.in);
		String assuntoTemp = "";

		System.out.println("Entre com um assunto para compromisso nessa data");
		assuntoTemp = obj.nextLine();

		Compromisso novoCompromisso = new Compromisso(dataVerificada.getDiaAno(), assuntoTemp);
		compromissos.add(novoCompromisso);
		System.out.println("Compromisso cadastrado:");
		novoCompromisso.imprimeCompromisso(novoCompromisso);

		// obj.close();

	}

	public static void criarCompromissoPeriodico(Data dataVerificada) {
		Scanner obj = new Scanner(System.in);
		String assuntoTemp = "";
		int recorrenteTemp = 0;
		int intervalTemp = 0;

		System.out.println("Entre com um assunto para compromisso nessa data ou 'F' para Finalizar");
		assuntoTemp = obj.nextLine();
		System.out.println("Entre com a quantidade de ocorr�ncias para o compromisso:");
		recorrenteTemp = Integer.parseInt(obj.nextLine());
		System.out.println("Entre com a quantidade de dias de intervalo entre os compromisso:");
		intervalTemp = Integer.parseInt(obj.nextLine());

		for (int i = 0; i < recorrenteTemp; i++) {
			Compromisso novoCompromisso = new Compromisso(dataVerificada.getDiaAno() + intervalTemp * i,
					assuntoTemp + "_" + (i + 1));
			compromissos.add(novoCompromisso);
		}
		System.out.println("Compromissos cadastrados:");
		for (Compromisso c : compromissos) {
			c.imprimeCompromisso(c);

		}
//		obj.close();

	}

	public static void teste() {
		Scanner obj = new Scanner(System.in);
		System.out.println("entre dia  + 'Enter' +  mes + 'Enter' + ano + 'Enter'.");
		int dia = Integer.parseInt(obj.nextLine());
		int mes = Integer.parseInt(obj.nextLine());
		int ano = Integer.parseInt(obj.nextLine());

		System.out.print(Data.diaAno(dia, mes, ano));

		System.out.println("");

		System.out.println("entre dia no ano.");
		int diaanotemp = Integer.parseInt(obj.nextLine());
		for (int n : Data.dataDiaAno(diaanotemp)) {
			System.out.print(n + "/");
			System.out.print("");
		}

	}

}
