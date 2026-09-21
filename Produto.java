public class Produto {

    public String nome;
    public double preco;
    public int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para adicionar.");
            return;
        }
        this.quantidade += quantidade;
        System.out.println(quantidade + " unidade(s) de \"" + nome + "\" adicionada(s) ao estoque.");
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para remover.");
            return;
        }
        if (quantidade > this.quantidade) {
            System.out.println("Estoque insuficiente de \"" + nome + "\". Disponível: " + this.quantidade);
            return;
        }
        this.quantidade -= quantidade;
        System.out.println(quantidade + " unidade(s) de \"" + nome + "\" removida(s) do estoque.");
    }

    public double calcularValorEstoque() {
        return preco * quantidade;
    }

    public void exibirDados() {
        System.out.printf(
            "Nome: %-15s | Preço: R$ %8.2f | Quantidade: %4d | Valor em estoque: R$ %10.2f%n",
            nome, preco, quantidade, calcularValorEstoque()
        );
    }
}