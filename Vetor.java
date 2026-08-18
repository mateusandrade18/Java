/*Desenvolva um programa que solicite ao usuário a quantidade de alunos de uma turma e armazene as notas deles em um array de
double. O programa deve calcular e exibir a média da turma, a maior nota, a menor nota e a quantidade de alunos aprovados,
considerando média mínima igual a 6,0. Utilize Scanner para a entrada, try/catch para tratar valores inválidos, conversão de tipos
quando necessário e um laço for para percorrer o array. Use if/else para classificar os alunos como aprovados ou reprovados.
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Vetor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a Quantidade de Alunos: ");

        int quantidadedeAlunos = sc.nextInt();
        System.out.println("Quantidade digitada:" + quantidadedeAlunos);

        double[] notas = new double[quantidadedeAlunos];

        for (int i = 0; i < quantidadedeAlunos; i++) {
            boolean notaValida = false;

            while (!notaValida) {
                try {
                    System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
                    notas[i] = sc.nextDouble();
                    notaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Valor invalido! Digite um numero.");
                    sc.next();
                }
            }
        }

        double soma = 0;
        double maiorNota = notas[0];
        double menorNota = notas[0];
        int aprovados = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];

            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
            if (notas[i] >= 6.0) {
                aprovados++;
            }
        }

        if (quantidadedeAlunos > 0){
            double mediaTurma = soma / quantidadedeAlunos; 

            System.out.println("\n=== ESTATÍSTICAS DA TURMA ===");
            System.out.printf("Média da turma: %.2f\n", mediaTurma);
            System.out.println("Menor nota: " + menorNota);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Alunos aprovados (Nota >= 6.0): " + aprovados);
            System.out.println("Alunos reprovados: " + (quantidadedeAlunos - aprovados));
        } else {
            System.err.println("\n\nNenhum Aluno Cadastrado.");
        }

        sc.close();
    }
}