import java.util.Scanner;

public class Exercicio01{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a nota 1: ");
        double n1 = leitor.nextDouble();
        System.out.print("Digite a nota 2: ");
        double n2 = leitor.nextDouble();
        System.out.print("Digite a nota 3: ");
        double n3 = leitor.nextDouble();

        double media = (n1 + n2 + n3) / 3;
        System.out.printf("Média: %.2f\n", media);

        if (media >= 7) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5) {
            System.out.println("Status: Recuperação");
        } else {
            System.out.println("Status: Reprovado");
        }
        leitor.close();
    }
}