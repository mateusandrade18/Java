import java.util.Scanner;

public class  Questao03 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       try {
           System.out.print("Digite um número: ");
           int n = sc.nextInt();

           for (int i = 1; i <= 10; i++) {
               System.out.println(n + " x " + i + " = " + (n * i));
           }

       } catch (Exception e) {
           System.out.println("Digite apenas numeros e nao letras. ");
       }

       sc.close();
   }
}