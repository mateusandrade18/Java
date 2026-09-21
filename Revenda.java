import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Revenda {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("==== REVENDA ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Vender Carro");
            System.out.println("3. Listar Carros");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) {
                case 0:
                    System.out.println("Adeus!");
                    break;
                case 1:
                    System.out.println("Digite a cor do carro: ");
                    String cor = s.next();
                    System.out.println("Digite a marca do carro");
                    String marca = s.next();
                    System.out.println("Digite a placa do carro: ");
                    String placa = s.next();
                    System.out.println("Digite o ano do carro: ");
                    int ano = s.nextInt();
                    Carro carro = new Carro(
                        cor,
                        ano,
                        marca,
                        placa
                    );
                    carros.add(carro);
                    break;
                case 2:
                    System.out.println("Digite a placa do carro: ");
                    String placaVenda = s.next();
                    for (Carro carroVenda : carros) {
                        if (carroVenda.placa.equals(placaVenda)) {
                            carroVenda.vender();
                            System.out.println("Venda realizada com sucesso!");
                        }
                    }
                    break;
                case 3:
                    for(Carro c : carros) {
                        System.out.println(
                            "Cor: " + c.cor + 
                            " Placa: " + c.placa +
                            " Marca: " + c.marca +
                            " Ano: " + c.ano + 
                            " Estoque: " + (c.estoque ? "Sim" : "Não")
                        );
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (opt != 0);
        s.close();
    }

    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);

        return opt;
    }
}
