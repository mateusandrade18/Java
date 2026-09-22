public class Aluno {
    public String nome;
    public int idade;
    public double nota1;
    public double nota2;

    public Aluno(String nome, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= 7.0;
    }

    public String situacaoTexto() {
        double media = calcularMedia();

        if (media >= 7.0) {
            return "Aprovado";
        } else if (media >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public void exibirSituacao() {
        System.out.printf(
            "Nome: %-15s | Idade: %3d | Média: %5.2f | Situação: %s%n",
            nome, idade, calcularMedia(), situacaoTexto()
        );
    }
}