public class Data {

    private int dia;
    private int mes;
    private int ano;

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

    public void imprimir() {
        System.out.printf("%d/%d/%d\n", dia, mes, ano);
    }

}
