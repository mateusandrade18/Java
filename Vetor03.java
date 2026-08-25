/* Desenvolva um programa que leia 15 números inteiros e armazene-os em um array. Depois, percorra o array e exiba separadamente os números pares e os números ímpares. Ao final, informe a quantidade de elementos de cada grupo.
Utilize o operador módulo (%) para identificar a paridade. O preenchimento do array deve ser feito com for, e o programa deve tratar entradas inválidas usando try/catch. */

import java.util.Scanner;

public class Vetor03 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        try {

            int[] valores = new int[15];

            int pares = 0;
            int impares = 0;

            System.out.println("===== ANÁLISE DE NÚMEROS =====");

            for (int posicao = 0; posicao < 15; posicao++) {

                System.out.print("Digite um número inteiro: ");
                valores[posicao] = entrada.nextInt();

            }

            System.out.println("\n--- RESULTADO ---");

            for (int posicao = 0; posicao < 15; posicao++) {

                if (valores[posicao] % 2 == 0) {

                    System.out.println("Par: " + valores[posicao]);
                    pares++;

                } else {

                    System.out.println("Ímpar: " + valores[posicao]);
                    impares++;

                }
            }

            System.out.println("\nTotal de pares: " + pares);
            System.out.println("Total de ímpares: " + impares);

        } catch (Exception erro) {

            System.out.println("Entrada inválida. Digite somente números inteiros.");

        }

    
    }
}