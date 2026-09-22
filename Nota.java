import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Nota {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Aluno> aluno = new ArrayList<>();
        int opt = -1;

        do {

            System.out.println("==== CADASTRO DE ALUNOS ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Exibir Situação de um Aluno");
            System.out.println("3. Lista de Alunos");
            System.out.println("4. Quantidade de Aprovados");
            System.out.println("5. Maior Média da Turma");
            System.out.println("Digite a operação: ");

            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                s.next();
                continue;
            }

            switch (opt) {

                case 0: {
                    System.out.println("Adeus!");

                    break;
                }

                case 1: {

                    System.out.println("Digite o nome do aluno: ");
                    String nome = s.next();

                    System.out.println("Digite a idade do aluno: ");
                    int idade = s.nextInt();

                    System.out.println("Digite a nota 1 do aluno: ");
                    double nota1 = s.nextDouble();

                    System.out.println("Digite a nota 2 do aluno: ");
                    double nota2 = s.nextDouble();

                    Aluno novoAluno = new Aluno(nome, idade, nota1, nota2);

                    aluno.add(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!");

                    break;
                }

                case 2: {

                    System.out.println("Digite o nome do aluno: ");
                    String nomeAluno = s.next();

                    boolean encontrado = false;

                    for (Aluno a : aluno) {
                        if (a.nome.equals(nomeAluno)) {
                            a.exibirSituacao();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;
                }

                case 3: {

                    if (aluno.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.println("==== LISTA DE ALUNOS ====");
                        for (Aluno a : aluno) {
                            a.exibirSituacao();
                        }
                    }

                    break;
                }

                case 4: {

                    int aprovados = 0;

                    for (Aluno a : aluno) {
                        if (a.estaAprovado()) {
                            aprovados++;
                        }
                    }

                    System.out.println("Quantidade de aprovados: " + aprovados);

                    break;
                }

                case 5: {

                    if (aluno.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        Aluno maiorMedia = aluno.get(0);

                        for (Aluno a : aluno) {
                            if (a.calcularMedia() > maiorMedia.calcularMedia()) {
                                maiorMedia = a;
                            }
                        }

                        System.out.printf(
                            "Maior média da turma: %s (%.2f)%n",
                            maiorMedia.nome, maiorMedia.calcularMedia()
                        );
                    }

                    break;
                }

                default: {
                    System.out.println("Opção inválida!");

                    break;
                }
            }

        } while (opt != 0);

        s.close();
    }
}