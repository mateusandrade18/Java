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


     while (opcao !=4){

        System.out.println("1 - Calcular área do quadrado.");
        System.out.println("2 - Calcular área do círculo.");
        System.out.println("3 - Calcular perímetro do retângulo.");
        System.out.println("4 - Sair.");

        try {

        opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o lado do quadrado: ");
                double lado = ler.nextDouble();
                double area = lado * lado;
                System.out.println("A área do quadrado é: " + area);
                break; 
        
            case 2:
                System.out.print("Digite o raio desse círculo: ");
                double raio = ler.nextDouble();
                double areaCirculo = Math.PI * raio * raio;
                System.out.println("A área desse círculo é: " + areaCirculo);

                break;

            case 3:
                System.out.print("Digite a base desse retângulo: ");
                double baseRetangulo = ler.nextDouble();

                System.out.print("Digite a altura desse retângulo: ");
                double alturaRetangulo = ler.nextDouble();

                double perimetro = 2 * (baseRetangulo + alturaRetangulo);
                System.out.println("O perímetro desse retângulo é: " + perimetro);
                break;
                
             case 4:
                System.out.println("Saindo do programa...");

                break; 

             default:
                System.out.println("Opção inválida! Digite uma opção de 1 a 4.");
                break;     

                
          }

        }
          catch (InputMismatchException e) {
        System.out.println("Digite apenas número, voltando ao menu: ");
        ler.next();

          }

        
        }

        ler.close();


    }
    
}
