/** Classe para tratar datas solicitadas pela aplicação */
public class Data {

    private int dia;
    private int mes;
    private int ano;
    private int diaAno;
    private String diaSemana;
    private boolean dataValida = false;

    /**
     * Contrutor da classe Data, recebe como parâmetro os elementos da data
     * validando as informações passadas por parâmetro. Ao receber data inválida,
     * retorna 0
     * Data válida exemplo: 01/01/2022
     * 
     * @param dia Dia para a data
     * @param mes Mês para a data
     * @param ano Ano para a data
     */
    public Data(int dia, int mes, int ano) {

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.diaAno = diaAno(dia, mes, ano);
        this.diaSemana = DiaSemana(dia, mes, ano);
        this.dataValida = (dia > 0) && (mes > 0) && (ano > 0) ? (true) : (false);
    }

    /**
     * Contrutor da classe Data, recebe como parâmetro um inteiro que representa o
     * dia incrementado a partir do dia 01/01/0001. Exemplo, o dia 24/08/2022 seria
     * 738391.
     * Ao receber um dia inválido, retorna 0
     * Data válida exemplo: 01/01/2022
     * 
     * @param diaAno Valor inteiro referente à data selecionada
     */
    public Data(int diaAno) {
        int[] dataconvert = dataDiaAno(diaAno);
        this.dia = dataconvert[0];
        this.mes = dataconvert[1];
        this.ano = dataconvert[2];
        this.diaAno = diaAno(dia, mes, ano);
        this.diaSemana = DiaSemana(dia, mes, ano);
        this.dataValida = (dia > 0) && (mes > 0) && (ano > 0) ? (true) : (false);
    }

    /** Construtor simples para criação de um objeto da classe Data */
    public Data() {

    }

    /**
     * Método para verificar se o ano passado como parâmetro é bissexto
     * 
     * @param ano Ano de uma data desejada
     * @return Retorna 1 quando é bissexto e 0 quando não é bissexto
     */
    public static int verificaBissexto(int ano) {
        int anoBis = 0;
        if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)) {
            anoBis = 1;
        }
        return anoBis;
    }

    /**
     * Método para retornar dia da semana em que a data passada como parâmetro
     * ocorre
     * 
     * @param dia Dia da data
     * @param mes Mês da data
     * @param ano Ano da data
     * @return Dia da semana em que a data ocorre, como por exemplo "Segunda-feira"
     */
    public static String DiaSemana(int dia, int mes, int ano) {
        String[] dSemana = { "Domingo", "Segunda-feira", "Ter�a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira",
                "S�bado" };
        int diaDaSemanaMes[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        if (mes < 3)
            ano -= 1;
        return dSemana[(ano + ano / 4 - ano / 100 + ano / 400 + diaDaSemanaMes[mes - 1] + dia) % 7];
    }

    /**
     * Método para verificar a quantidade de dias no mês, validando inclusive se o
     * ano é bissexto
     * algoritmo inspirado no algoritmo
     * 
     * @param mes Mes da data
     * @param ano Ano da Data
     * @return Quantidade de dias no mês
     */
    public static int diasMes(int mes, int ano) {
        int dMes = 31 - ((mes == 2) ? (3 - verificaBissexto(ano)) : (((mes - 1) % 7) % 2));
        return dMes;
    }

    public static int diaAno(int dia, int mes, int ano) {
        int diaAno = 0;

        for (int a = 1; a < ano; a++) {
            for (int m = 1; m <= 12; m++) {
                diaAno += diasMes(m, a);
            }
        }
        // System.out.println("acum " + diaAno);
        for (int m = 1; m < mes; m++) {
            diaAno += diasMes(m, ano);
        }

        diaAno = diaAno + dia;
        return diaAno;
    }

    public static int[] dataDiaAno(int diaAno) {
        int diaAnoTemp = diaAno;
        if (diaAno >= 1) {
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

            int[] dataDiaAnoTemp = { diaAnoTemp, mesTemp, ano };
            return dataDiaAnoTemp;
        } else {
            int[] dataDiaAnoTemp = { 0, 0, 0 };
            return dataDiaAnoTemp;
        }

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
                    System.out.println("� uma data v�lida! ");
                    System.out.println(
                            "Dia " + diaAgenda.getDia() + "/" + diaAgenda.getMes() + "/" + diaAgenda.getAno());
                    System.out.println("Dia semana = " + Data.DiaSemana(dia, mes, ano) + "\n");
                    dataAvaliada = diaAgenda;
                }
            }
        }
        return dataAvaliada;
    } // Retorna dia 0 m�s 0 ano 0 se inv�lida.

    public static boolean ehValorValido(int dia, int mes, int ano) {
        boolean vVale = false;
        if (dia > 0 && mes > 0 && ano > 0) {
            if (dia <= diasMes(mes, ano) && mes <= 12 && ano < 10000) {
                vVale = true;
            } else {
                if (dia <= 0 || dia > diasMes(mes, ano)) {
                    // System.out.println("O dia " + dia + " n�o � valido para o m�s " + mes);
                    // System.out.println("O m�s " + mes + " tem " + diasMes(mes, ano) + " dias.");
                    Agenda.excessaw = Agenda.excessaw + "\"O dia \" + dia + \" n�o � valido para o m�s \" + mes\n"
                            + "O m�s " + mes + " tem " + diasMes(mes, ano) + " dias.\n";
                }
                if (mes <= 0 || mes > 12) {
                    // System.out.println("O m�s " + mes + " n�o � valido.");
                    Agenda.excessaw = Agenda.excessaw + "O m�s " + mes + " n�o � valido.\n";
                }
                if (ano == 2038) {
                    // System.out.println(
                    // "O ano " + ano + " n�o � contemplado na avalia��o. Problema Y2K38 - Gangnam
                    // Style. :-) ");
                    Agenda.excessaw = Agenda.excessaw + "O ano " + ano
                            + " n�o � contemplado na avalia��o. Problema Y2K38 - Gangnam Style. :-) \n";
                }
                if (ano > 10000) {
                    // System.out.println("Ano " + ano + " � inv�lido!");
                    // System.out.println("Os anos p�s 10.000 n�o s�o avaliados.");
                    Agenda.excessaw = Agenda.excessaw + "Ano " + ano + " � inv�lido!\n";
                    Agenda.excessaw = Agenda.excessaw + "Os anos p�s 10.000 n�o s�o avaliados.\n";

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
                        // System.out.println("Apenas n�meros no formato DD/MM/AAAA s�o v�lidos! ");
                        Agenda.excessaw = Agenda.excessaw + "Apenas n�meros no formato DD/MM/AAAA s�o v�lidos!\n ";
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