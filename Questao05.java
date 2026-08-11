/*
Crie um programa de menu que oferece as seguintes opções: (1) Calcular área de um quadrado,
(2) Calcular área de um círculo, (3) Calcular perímetro de um retângulo, (4) Sair. Utilize switch para
controlar o fluxo, Scanner para entrada e try/catch para tratamento de erros.
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao05 {
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

                            double area = lado * lado;
                            System.out.println("A área do quadrado é: " + area);

                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números.");
                            ler.next();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Digite o raio do círculo: ");
                            double raio = ler.nextDouble();

                            double areaCirculo = Math.PI * raio * raio;
                            System.out.println("A área do círculo é: " + areaCirculo);

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

                            double perimetro = 2 * (base + altura);
                            System.out.println("O perímetro é: " + perimetro);

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
