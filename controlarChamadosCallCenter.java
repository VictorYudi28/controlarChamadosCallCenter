import java.util.Scanner;

public class controlarChamadosCallCenter {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        String tiposCriteriosChamadas[] = new String[] {"Sistema parado","Grave","Não grave","Dúvida"};

        int chamadosDados[][] = captacaoCamposFuncionario();

        pulaLinha();

        calculaMostrarRelatorioErrosChamados(chamadosDados);

        int quantCriterios[] = calculaQuantCriterios(chamadosDados);

        pulaLinha();

        System.out.println("----- Relatório de chamados por critério -----");

        pulaLinha();

        for(int i = 0; i < tiposCriteriosChamadas.length; i++) {

            System.out.println("Número de chamados - " + tiposCriteriosChamadas[i] + ": " + quantCriterios[i]);

        }// For exibe relatório de chamados por critério

    }// Main

    public static void pulaLinha() {

        for (int i = 0; i < 2; i++) {
            System.out.println();
        }

    }// Função pula linha

    public static int[][] captacaoCamposFuncionario() {

        int chamadosDados[][] = new int[5][3];

        for (int i = 0; i < 5; i++) {

            System.out.println("Digite a indentificação do funcionário: ");
            chamadosDados[i][0] = entrada.nextInt();

            System.out.println(
                    "Digite o código" + " de erro: 1) - Sistema não inicia 2) - Nome ou caminho do banco de dados"
                            + " não encontrado 3) - Sistema não responde: ");
            chamadosDados[i][1] = entrada.nextInt();

            while (chamadosDados[i][1] != 1 && chamadosDados[i][1] != 2 && chamadosDados[i][1] != 3) {

                System.out.println(
                        "Digite novamente " + " de erro: - 1) Sistema não inicia - 2) Nome ou caminho do banco de dados"
                                + " não encontrado - 3) Sistema não responde: ");
                chamadosDados[i][1] = entrada.nextInt();

            } // While validação código erro

            System.out.println("Digite o críterio do chamado: ");
            System.out.println("01) Sistema parado - 12) Grave - 23) Não grave 34) Duvida ou questão");
            chamadosDados[i][2] = entrada.nextInt();

            while (chamadosDados[i][2] != 01 && chamadosDados[i][2] != 12 && chamadosDados[i][2] != 23
                    && chamadosDados[i][2] != 34) {

                System.out.println("Digite novamente: ");
                System.out.println("01) Sistema parado - 12) Grave - 23) Não grave 34) Duvida ou questão");
                chamadosDados[i][2] = entrada.nextInt();

            } // Validação críterio do chamado

            pulaLinha();

        } // Linhas

        return chamadosDados;

    }// Função captação campos funcionários

    public static void calculaMostrarRelatorioErrosChamados(int chamadosDados[][]) {
        int sistemaNaoInicia = 0, nomeOuCaminho = 0, sistemaNaoResponde = 0;

        for (int i = 0; i < 5; i++) {

            switch (chamadosDados[i][1]) {

                case 1:
                    sistemaNaoInicia++;
                    break;
                case 2:
                    nomeOuCaminho++;
                    break;
                case 3:
                    sistemaNaoResponde++;
                    break;

            }// Verifica quantidade em cada erro

        } // For Verifica quantidade em cada erro

        System.out.println("----- Relatório de chamados por erro -----");

        pulaLinha();

        System.out.println("Números de chamados com o código do erro 1: " + sistemaNaoInicia);
        System.out.println("Números de chamados com o código do erro 2: " + nomeOuCaminho);
        System.out.println("Números de chamados com o código do erro 3: " + sistemaNaoResponde);

    }// Função mostrar relatório erros chamados

    public static int[] calculaQuantCriterios(int chamadosDados[][]) {

        int quantCriterios[] = new int[5];
        int sistemaParado = 0, grave = 0, naoGrave = 0, duvida = 0;

        for (int i = 0; i < 5; i++) {

            switch (chamadosDados[i][2]) {

                case 01:
                    sistemaParado++;
                    break;
                case 12:
                    grave++;
                    break;
                case 23:
                    naoGrave++;
                    break;
                case 34:
                    duvida++;

            }

        } // For quantidades critérios

        for (int i = 0; i < 4; i++) {

            if (i == 0) {
                quantCriterios[i] = sistemaParado;
            } else if (i == 1) {
                quantCriterios[i] = grave;
            } else if (i == 2) {
                quantCriterios[i] = naoGrave;
            } else if (i == 3) {
                quantCriterios[i] = duvida;
            }

        } // For preenche vetor, com a quantidade dos critérios

        return quantCriterios;

    }// Função calcula a quantidade dos critérios das chamadas

}// Class