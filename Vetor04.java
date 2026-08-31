/*
Questão 4: Lista de Compras com ArrayList
Crie um programa que utilize uma ArrayList<String![alt text](https://example.com)> para representar uma lista de compras. O programa deve apresentar um menu com as opções: 
Utilize switch para controlar o menu, Scanner para ler as informações e try/catch para tratar opções inválidas. O programa deve continuar executando dentro de um laço 
do/while até que o usuário escolha a opção de encerramento.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vetor04 {
    public static void main(String[] args) {
        Scanner lista = new Scanner(System.in);
        ArrayList<String> compras = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("\n===== LISTA DE COMPRAS =====");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("3 - Listar itens");
            System.out.println("4 - Encerrar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(lista.nextLine().trim());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do item: ");
                        String item = lista.nextLine();
                        compras.add(item);
                        System.out.println("Item \"" + item + "\" adicionado.");
                        break;

                    case 2:
                        if (compras.isEmpty()) {
                            System.out.println("A lista está vazia.");
                            break;
                        }
                        System.out.print("Digite o nome do item a remover: ");
                        String remover = lista.nextLine();
                        if (compras.remove(remover)) {
                            System.out.println("Item \"" + remover + "\" removido.");
                        } else {
                            System.out.println("Item não encontrado na lista.");
                        }
                        break;

                    case 3:
                        if (compras.isEmpty()) {
                            System.out.println("A lista de compras está vazia.");
                        } else {
                            System.out.println("Itens na lista:");
                            for (int i = 0; i < compras.size(); i++) {
                                System.out.println((i + 1) + " - " + compras.get(i));
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Encerrando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida! Escolha um número entre 1 e 4.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                opcao = 0; // garante que o laço continue
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada! Tente novamente.");
                opcao = 0;
            }

        } while (opcao != 4);

        lista.close();
    }
}