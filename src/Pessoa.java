import java.util.*;

class Pessoa {
    private String nome;
    private String documento;
    private int idade;

    public Pessoa(String nome, String documento, int idade) {
        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Documento: " + documento + ", Idade: " + idade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(documento, pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}