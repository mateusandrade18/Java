import java.util.Scanner;

public class Questao02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Digite sua idade: ");

            int idade = sc.nextInt();

            if (idade >= 60) {

                System.out.println("Idoso");

            } else if (idade >= 18) {

                System.out.println("Maior de idade");

            } else {

                System.out.println("Menor de idade");

            }

        } catch (Exception e) {

            System.out.println("Erro, Digite idade completa e sem letras. ");

        }

        sc.close();

    }

}