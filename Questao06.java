/*
Desenvolva um jogo em que o programa gera um número aleatório entre 1 e 100, e o usuário
tenta adivinhar. Utilize while para repetir até acertar, if/else para comparar o palpite com o
número secreto, Scanner para entrada e try/catch para validação. Exiba dicas ("maior" ou
"menor") a cada tentativa.
*/


import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao06 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n1 - Calcular área do quadrado.");
            System.out.println("2 - Calcular área do círculo.");
            System.out.println("3 - Calcular perímetro do retângulo.");
            System.out.println("4 - Sair.");
            System.out.print("Escolha uma opção: ");

            try {

                opcao = ler.nextInt();

                switch (opcao) {

                    case 1:
                        try {
                            System.out.print("Digite o lado do quadrado: ");
                            double lado = ler.nextDouble();

                            if (lado <= 0) {
                                System.out.println("O valor deve ser positivo.");
                            } else {
                                double area = lado * lado;
                                System.out.printf("A área do quadrado é: %.2f%n", area);
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números.");
                            ler.next();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Digite o raio do círculo: ");
                            double raio = ler.nextDouble();

                            if (raio <= 0) {
                                System.out.println("O valor deve ser positivo.");
                            } else {
                                double areaCirculo = Math.PI * raio * raio;
                                System.out.printf("A área do círculo é: %.2f%n", areaCirculo);
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números.");
                            ler.next();
                        }
                        break;

                    case 3:
                        try {
                            System.out.print("Digite a base do retângulo: ");
                            double base = ler.nextDouble();

                            System.out.print("Digite a altura do retângulo: ");
                            double altura = ler.nextDouble();

                            if (base <= 0 || altura <= 0) {
                                System.out.println("Os valores devem ser positivos.");
                            } else {
                                double perimetro = 2 * (base + altura);
                                System.out.printf("O perímetro é: %.2f%n", perimetro);
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números.");
                            ler.next();
                        }
                        break;

                    case 4:
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida! Digite de 1 a 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números no menu.");
                ler.next();
            }
        }

        ler.close();
    }
}