import java.util.Scanner;

public class tentativajogodavelha {
    static int L;
    static int C;
    static char vitorioso = ' ';
    static int rodadas = 1;
    static Scanner sc = new Scanner(System.in);
    static char tabuleiro[][] = new char[3][3];
    static char jogadorAtual = 'X';

    public static void inicio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void desenhar() {
        System.out.println("  0  1  2");
        System.out.println("0 " + tabuleiro[0][0] + "|" + tabuleiro[0][1] + " |" + tabuleiro[0][2] + " |");
        System.out.println("1 " + tabuleiro[1][0] + "|" + tabuleiro[1][1] + " |" + tabuleiro[1][2] + " |");
        System.out.println("2 " + tabuleiro[2][0] + "|" + tabuleiro[2][1] + " |" + tabuleiro[2][2] + " |");
    }

    public static char verificarvitoria(char tabuleiro[][]) {

        for (int i = 0; i < 3; i++) {
            //linha
            if (tabuleiro[i][0] != ' ' &&
                    tabuleiro[i][0] == tabuleiro[i][1] &&
                    tabuleiro[i][1] == tabuleiro[i][2])
                return tabuleiro[i][0];

            //coluna
            if (tabuleiro[0][i] != ' ' && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i])
                return tabuleiro[0][i];
        }
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2])
            return tabuleiro[0][0];
        if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0])
            return tabuleiro[0][2];
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("bem vindo ao jogo da velha!");
        sc.nextLine();
        inicio();
        do {
            System.out.println("rodada "+ rodadas);
            desenhar();
            System.out.println("vez do jogador " + jogadorAtual);
            System.out.println("Linha: ");
            L = sc.nextInt();
            System.out.println("Coluna: ");
            C = sc.nextInt();
            if (verificarjogada()) {
                tabuleiro[L][C] = jogadorAtual;
                rodadas++;
                if (jogadorAtual == 'X') {
                    jogadorAtual = 'O';
                } else {
                    jogadorAtual = 'X';
                }
            } else {
                System.out.println("essa casa ja foi utilizada");
            }

        } while (verificarvitoria(tabuleiro) == ' ' && rodadas < 10);
        desenhar();
        vitorioso = verificarvitoria(tabuleiro);
        if (vitorioso != ' ') {
            System.out.println("O jogador " + vitorioso + " venceu");
        }else{
            System.out.println("empate");
        }
    }
    public static boolean verificarjogada() {
        if (tabuleiro[L][C] != ' ') {
            return false;
        }
        return true;
    }

}