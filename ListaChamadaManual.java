import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Sistema simples de gerenciamento de Lista de Chamada (turma escolar),
 * implementado manualmente sobre um vetor (array) de tamanho fixo,
 * sem uso de bibliotecas prontas de coleção da linguagem Java.
 *
 * Cada "número de chamada" da turma é uma posição do vetor.
 * - Entrada = matrícula de um aluno (ocupa um número de chamada)
 * - Saída   = remoção do aluno da turma (libera o número de chamada)
 */
public class ListaChamadaManual {

    static final int TOTAL_VAGAS = 5;
    static Aluno[] turma = new Aluno[TOTAL_VAGAS];
    static int quantidadeMatriculados = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Bem-vindo ao Sistema de Lista de Chamada!");

        while (continuar) {
            exibirMenu();
            int opcao = lerInteiro(entrada, "Escolha uma opção: ");

            switch (opcao) {
                case 1: {
                    registrarEntrada(entrada);
                    break;
                }
                case 2: {
                    int numero = lerInteiro(entrada, "Digite o número de chamada para remover o aluno: ");
                    registrarSaidaPorNumero(numero);
                    break;
                }
                case 3: {
                    System.out.print("Digite o nome do aluno que deseja remover: ");
                    String nome = entrada.nextLine();
                    registrarSaidaPorNome(nome);
                    break;
                }
                case 4: {
                    System.out.print("Digite o nome do aluno que deseja pesquisar: ");
                    String nome = entrada.nextLine();
                    pesquisarPorNome(nome);
                    break;
                }
                case 5: {
                    int numero = lerInteiro(entrada, "Digite o número de chamada que deseja consultar: ");
                    pesquisarPorNumero(numero);
                    break;
                }
                case 6: {
                    listarMatriculados();
                    break;
                }
                case 7: {
                    System.out.println("Encerrando o sistema. Até mais!");
                    continuar = false;
                    break;
                }
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                }
            }
            System.out.println();
        }

        entrada.close();
    }

    

    static class Aluno {
        String nome;
        int idade;
        String turmaOuDisciplina;

        Aluno(String nome, int idade, String turmaOuDisciplina) {
            this.nome = nome;
            this.idade = idade;
            this.turmaOuDisciplina = turmaOuDisciplina;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + " | Idade: " + idade + " | Turma/Disciplina: " + turmaOuDisciplina;
        }
    }

    

    static void exibirMenu() {
        System.out.println("========== MENU LISTA DE CHAMADA ==========");
        System.out.println("1 - Registrar entrada (matricular aluno)");
        System.out.println("2 - Registrar saída pelo número de chamada (remover)");
        System.out.println("3 - Registrar saída pelo nome do aluno (remover)");
        System.out.println("4 - Pesquisar aluno pelo nome");
        System.out.println("5 - Pesquisar aluno pelo número de chamada");
        System.out.println("6 - Listar todos os alunos matriculados");
        System.out.println("7 - Encerrar o programa");
        System.out.println("============================================");
    }

   

    static int lerInteiro(Scanner entrada, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = entrada.nextInt();
                entrada.nextLine(); 
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite apenas valores numéricos válidos.");
                entrada.next();
            }
        }
    }

    

    static void registrarEntrada(Scanner entrada) {
        if (quantidadeMatriculados >= TOTAL_VAGAS) {
            System.out.println("Erro: a lista de chamada está com todas as vagas ocupadas!");
            return;
        }

        System.out.print("Nome do aluno: ");
        String nome = entrada.nextLine();
        int idade = lerInteiro(entrada, "Idade do aluno: ");
        System.out.print("Turma/Disciplina: ");
        String turmaOuDisciplina = entrada.nextLine();

        
        for (int i = 0; i < TOTAL_VAGAS; i++) {
            if (turma[i] == null) {
                turma[i] = new Aluno(nome, idade, turmaOuDisciplina);
                quantidadeMatriculados++;
                System.out.println("Aluno " + nome + " matriculado no número de chamada " + i + ".");
                return;
            }
        }
    }

    

    static void registrarSaidaPorNumero(int numero) {
        if (numero < 0 || numero >= TOTAL_VAGAS) {
            System.out.println("Erro: número de chamada inválido. Deve estar entre 0 e " + (TOTAL_VAGAS - 1) + ".");
            return;
        }
        if (turma[numero] == null) {
            System.out.println("Erro: o número de chamada " + numero + " já está vazio.");
            return;
        }

        System.out.println("Aluno " + turma[numero].nome + " foi removido do número de chamada " + numero + ".");
        turma[numero] = null;
        quantidadeMatriculados--;
    }

    static void registrarSaidaPorNome(String nome) {
        for (int i = 0; i < TOTAL_VAGAS; i++) {
            if (turma[i] != null && turma[i].nome.equalsIgnoreCase(nome)) {
                registrarSaidaPorNumero(i);
                return;
            }
        }
        System.out.println("Aluno \"" + nome + "\" não encontrado entre os matriculados.");
    }

    // ---------- Pesquisa ----------

    static void pesquisarPorNome(String nome) {
        for (int i = 0; i < TOTAL_VAGAS; i++) {
            if (turma[i] != null && turma[i].nome.equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado no número de chamada " + i + " -> " + turma[i]);
                return;
            }
        }
        System.out.println("Aluno \"" + nome + "\" não encontrado na turma.");
    }

    static void pesquisarPorNumero(int numero) {
        if (numero < 0 || numero >= TOTAL_VAGAS) {
            System.out.println("Erro: número de chamada inválido. Deve estar entre 0 e " + (TOTAL_VAGAS - 1) + ".");
            return;
        }
        if (turma[numero] == null) {
            System.out.println("O número de chamada " + numero + " está vazio no momento.");
        } else {
            System.out.println("Número " + numero + " -> " + turma[numero]);
        }
    }

    // ---------- Listagem ----------

    static void listarMatriculados() {
        if (quantidadeMatriculados == 0) {
            System.out.println("Não há alunos matriculados no momento.");
            return;
        }

        System.out.println("============ ALUNOS MATRICULADOS ============");
        for (int i = 0; i < TOTAL_VAGAS; i++) {
            if (turma[i] != null) {
                System.out.println("Número " + i + " -> " + turma[i]);
            }
        }
        System.out.println("Total matriculados: " + quantidadeMatriculados + "/" + TOTAL_VAGAS);
        System.out.println("================================================");
    }
}