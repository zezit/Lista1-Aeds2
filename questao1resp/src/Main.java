import java.util.Scanner;

public class Main {
    private static final int TOTAL_QUESTOES = 8;
    private static final int ALUNOS = 10;

    private static char[] gabarito = new char[TOTAL_QUESTOES];

    private static int[][] notas = new int[ALUNOS][2];

    private static char[] lerRespostas(String identificador) {
        System.out.println(identificador + ":");

        char[] respostasArray = new char[TOTAL_QUESTOES];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < respostasArray.length; i++) {
            System.out.print("Digite a resposta da questao "+ (i+1) + ": ");
            respostasArray[i] = scanner.nextLine().charAt(0);
        }

        System.out.println("As respostas inseridas foram:");
        for (int i = 0; i < respostasArray.length; i++) {
            System.out.println("Questao " + (i+1) + ": " + respostasArray[i]);
        }

        return respostasArray;
    }

    private static int[][]lerRespostasProvas(String identificador) {
        System.out.println(identificador + ":");

        int[][] respostasArray = new int[ALUNOS][2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < respostasArray.length; i++) {
            MyIO.println("Digite o numero do aluno: ");
            respostasArray[i][0] = scanner.nextInt();
            scanner.nextLine();

            respostasArray[i][1] = 0;
            for (int j = 0; j < TOTAL_QUESTOES; j++) {
                MyIO.println("Digite a resposta da questao " + (j + 1) + " do aluno " + respostasArray[i][0] +": ");
                respostasArray[i][1] = respostasArray[i][1] + respostaCorreta(scanner.nextLine().charAt(0), j);
            }
            MyIO.println("");
        }

        for (int i = 0; i < respostasArray.length; i++) {
            MyIO.println("Acertos do aluno " + respostasArray[i][0] +": "+respostasArray[i][1]);
        }

        return respostasArray;
    }

    public static int respostaCorreta(char resposta, int numeroQuestao) {
        if(resposta == gabarito[numeroQuestao]){
//            MyIO.println("RESPOSTA CORRETA");
            return 1;
        }else{
//            MyIO.println("RESPOSTA ERRADA");
            return 0;
        }
    }

    public static void main(String[] args) {
        // Leitura do gabarito
        gabarito = lerRespostas("Digite o gabarito da prova");

        // Leitura das respostas dos alunos e cálculo das notas
        notas = lerRespostasProvas("Digite as respostas dos alunos");

        int aprovePercent = 0;
        for (int i = 0; i<ALUNOS; i++){
            if(notas[i][1] >= 5){
                aprovePercent = aprovePercent +1;
            }
        }
        aprovePercent = aprovePercent * 100 / 10;

        MyIO.println("Porcentagem de aprovacao da turma: "+aprovePercent+"%");
    }
}
