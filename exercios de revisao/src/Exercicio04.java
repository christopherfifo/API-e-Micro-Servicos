public class Exercicio04 {
    public static void main(String[] args) {
        int[] numeros = {12, 5, 8, 21, 14, 7, 3, 10};
        int soma = 0;

        for (int n : numeros) {
            if (n % 2 != 0) {
                soma += n;
            }
        }

        System.out.println("A soma dos números ímpares é: " + soma);
    }
}