import java.util.Scanner;

public class Questao01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
aaaaaaaaaaaaaaaaa
            System.out.print("Primeiro número: ");

            int a = sc.nextInt();

            System.out.print("Segundo número: ");

            int b = sc.nextInt();

            System.out.println("Soma: " + (a + b));

            System.out.println("Subtração: " + (a - b));

            System.out.println("Multiplicação: " + (a * b));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida.");
        } finally {
            sc.close();
        }
    }
}
