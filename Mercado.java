import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mercado {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opt = -1;

        do {

            System.out.println("==== MERCADO ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Quantidade de Produto");
            System.out.println("3. Lista de Produtos");
            System.out.println("4. Adicionar Estoque");
            System.out.println("5. Remover Estoque");
            System.out.println("6. Valor Total do Estoque");
            System.out.println("7. Produto com Maior Valor em Estoque");
            System.out.println("Digite a operação: ");

            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                s.next(); // limpa o valor inválido do buffer
                continue;
            }

            switch (opt) {

                case 0: {
                    System.out.println("Adeus!");

                    break;
                }

                case 1: {

                    System.out.println("Digite o nome do produto: ");
                    String nome = s.next();
                    System.out.println("Digite o valor do produto: ");
                    double preco = s.nextDouble();
                    System.out.println("Digite a quantidade do produto");
                    int quantidade = s.nextInt();
                    Produto produto = new Produto(nome, preco, quantidade);
                    produtos.add(produto);
                    System.out.println("Produto cadastrado com sucesso!");

                    break;
                }

                case 2: {

                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = s.next();
                    boolean encontrado = false;
                    for (Produto produto : produtos) {
                        if (produto.nome.equals(nomeProduto)) {
                            System.out.println("Quantidade disponível: " + produto.quantidade);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                }

                case 3: {

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("==== LISTA DE PRODUTOS ====");
                        for (Produto produto : produtos) {
                            produto.exibirDados();
                        }
                    }

                    break;
                }

                case 4: {

                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = s.next();

                    Produto encontrado = null;

                    for (Produto produto : produtos) {
                        if (produto.nome.equals(nomeProduto)) {
                            encontrado = produto;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Produto não encontrado.");
                    } else {
                        System.out.println("Digite a quantidade a adicionar: ");
                        int quantidade = s.nextInt();
                        encontrado.adicionarEstoque(quantidade);
                    }

                    break;
                }

                case 5: {

                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = s.next();

                    Produto encontrado = null;

                    for (Produto produto : produtos) {
                        if (produto.nome.equals(nomeProduto)) {
                            encontrado = produto;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Produto não encontrado.");
                    } else {
                        System.out.println("Digite a quantidade a remover: ");
                        int quantidade = s.nextInt();
                        encontrado.removerEstoque(quantidade);
                    }

                    break;
                }

                case 6: {

                    double valorTotal = 0;

                    for (Produto produto : produtos) {
                        valorTotal += produto.calcularValorEstoque();
                    }

                    System.out.printf("Valor total armazenado no estoque: R$ %.2f%n", valorTotal);

                    break;
                }

                case 7: {

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        Produto maiorValor = produtos.get(0);

                        for (Produto produto : produtos) {
                            if (produto.calcularValorEstoque() > maiorValor.calcularValorEstoque()) {
                                maiorValor = produto;
                            }
                        }

                        System.out.printf(
                            "Produto com maior valor em estoque: %s (R$ %.2f)%n",
                            maiorValor.nome, maiorValor.calcularValorEstoque()
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