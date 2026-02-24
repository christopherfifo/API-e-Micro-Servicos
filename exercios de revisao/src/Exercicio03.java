import java.util.Scanner;
import java.util.Random;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroSecreto = new Random().nextInt(100) + 1;
        int palpite = 0;
        int tentativas = 0;

        System.out.println("Tente adivinhar o número entre 1 e 100!");

        while (palpite != numeroSecreto) {
            System.out.print("Seu palpite: ");
            palpite = entrada.nextInt();
            tentativas++;

            if (palpite < numeroSecreto) {
                System.out.println("Muito baixo!");
            } else if (palpite > numeroSecreto) {
                System.out.println("Muito alto!");
            }
        }

        System.out.println("Acertou em " + tentativas + " tentativas!");
    }
}