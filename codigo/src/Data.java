public class Data {

    private int dia;
    private int mes;
    private int ano;
    private int diaSemana;

    public Data(int dia, int mes, int ano) {
        if (this.validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data invalida");
        }
    }

    /***
     * Metodo de validadação de veracidade da data
     * 
     * @param dia
     * @param mes
     * @param ano
     * @return
     */

    public boolean validarData(int dia, int mes, int ano) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
            return dia >= 1 && dia <= 31;
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
            return dia >= 1 && dia <= 30;
        else if (mes == 2) {
            if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))
                return dia >= 1 && dia <= 29;

            return dia >= 1 && dia <= 28;
        }

        return mes >= 1 && mes <= 12 && ano > 0;
    }

    /**
     * Formula para descobrir dia da semana
     */

    public void diaDaSemana() {
        if (mes == 01) {
            mes = 13;
            ano = ano - 1;
        }
        if (mes == 02) {
            mes = 14;
            ano = ano - 1;
        }
        int formula = dia + 2 * mes + (3 * (mes + 1) / 5) + ano + ano / 4 - ano / 100 + ano / 400 + 2;
        diaSemana = formula % 7;

        if (mes == 13) {
            mes = 1;
            ano = ano + 1;
        }
        if (mes == 14) {
            mes = 2;
            ano = ano + 1;
        }
        switch (diaSemana) {
            case 0:
                System.out.println("Sábado");
                break;

            case 1:
                System.out.println("Domingo");
                break;

            case 2:
                System.out.println("Segunda-feira");
                break;

            case 3:
                System.out.println("Terca-feira");
                break;

            case 4:
                System.out.println("Quarta-feira");
                break;

            case 5:
                System.out.println("Quinta-feira");
                break;

            case 6:
                System.out.println("Sexta-feira");
                break;

        }
    }

    public void imprimirData() {
        System.out.println("Data:" + dia + "/" + mes + "/" + ano);
    }

}
