import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[3][4];
        int maior = 0, menor = Integer.MAX_VALUE;
        int linhaMaior = 0, colunaMaior = 0, linhaMenor = 0, colunaMenor = 0;
        Scanner input = new Scanner(System.in);

        for (int line = 0; line < 3; line++){
            for (int col = 0; col < 4; col++){
                matriz[line][col] = input.nextInt();
                input.nextLine();
            }
        }

        maior = matriz[0][0];
        menor = matriz[0][0];

        for (int line = 0; line < 3; line++){
            for (int col = 0; col < 4; col++){
                if(matriz[line][col] > maior){
                    maior = matriz[line][col];
                    linhaMaior = line;
                    colunaMaior = col;
                }

                if(matriz[line][col] < menor){
                    menor = matriz[line][col];
                    linhaMenor = line;
                    colunaMenor = col;
                }
            }
        }

        // Imprime a matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        MyIO.println("O maior elemento da matriz informada é: "+maior);
        MyIO.println("Sua posicao é: ["+linhaMaior+","+colunaMaior+"]");
        MyIO.println("O menor elemento da matriz informada é: "+menor);
        MyIO.println("Sua posicao é: ["+linhaMenor+","+colunaMenor+"]");
    }
}