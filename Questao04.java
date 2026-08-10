/*
Desenvolva um programa que leia números inteiros do usuário em um laço while até que ele
digite 0 (zero). Ao final, exiba a soma de todos os números digitados. Utilize try/catch para tratar
entradas inválidas.
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao04 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);

        int soma = 0;
        int valor = 0;

        try {

            System.out.print("Digite um valor: ");
            valor = numero.nextInt();

            while (valor != 0) {

                soma = soma + valor;

                System.out.print("Digite um valor: ");
                valor = numero.nextInt();
            }

            System.out.println("A soma dos valores é: " + soma);

        } catch (InputMismatchException e) {
            System.out.println("Digite apenas numeros inteiros.");
        }

        numero.close();
    }
}