import java.util.*;

public class Teste {
    public static void main(String[] args) {
        /* Exemplo de criação de uma lista de pessoas */
        List<Pessoa> listaPessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa("João", "123456789", 30);
        Pessoa pessoa2 = new Pessoa("Maria", "987654321", 25);

        /* 3. Adiciona uma pessoa à lista e retorna a lista preenchida */
        adicionarPessoaNaLista(listaPessoas, pessoa1);
        adicionarPessoaNaLista(listaPessoas, pessoa2);
        System.out.println("Lista após adição:");
        imprimirLista(listaPessoas);

        /* 4. Remove duplicados utilizando o Set */
        Pessoa pessoaDuplicada = new Pessoa("Maria", "987654321", 25);
        adicionarPessoaNaLista(listaPessoas, pessoaDuplicada);
        listaPessoas = removerDuplicados(listaPessoas);
        System.out.println("Lista após remover duplicados:");
        imprimirLista(listaPessoas);

        /* 5. Adiciona uma pessoa ao mapa e imprime os dados */
        Map<String, Pessoa> mapaPessoas = new HashMap<>();
        adicionarPessoaNoMapa(mapaPessoas, pessoa1);
        adicionarPessoaNoMapa(mapaPessoas, pessoa2);
        imprimirPessoaNoMapa(mapaPessoas, "123456789");

        // 6. Ordena a lista em ordem crescente e decrescente
        System.out.println("Lista em ordem crescente por idade:");
        List<Pessoa> listaOrdenadaCrescente = ordenarListaPorIdade(listaPessoas, true);
        imprimirLista(listaOrdenadaCrescente);

        System.out.println("Lista em ordem decrescente por idade:");
        List<Pessoa> listaOrdenadaDecrescente = ordenarListaPorIdade(listaPessoas, false);
        imprimirLista(listaOrdenadaDecrescente);
    }

    static List<Pessoa> adicionarPessoaNaLista(List<Pessoa> lista, Pessoa pessoa) {
        lista.add(pessoa);
        return lista;
    }

    static List<Pessoa> removerDuplicados(List<Pessoa> lista) {
        Set<Pessoa> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }

    static void adicionarPessoaNoMapa(Map<String, Pessoa> mapa, Pessoa pessoa) {
        mapa.put(pessoa.getDocumento(), pessoa);
    }

    static void imprimirPessoaNoMapa(Map<String, Pessoa> mapa, String documento) {
        Pessoa pessoa = mapa.get(documento);
        if (pessoa != null) {
            System.out.println("Pessoa encontrada: " + pessoa);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    static List<Pessoa> ordenarListaPorIdade(List<Pessoa> lista, boolean crescente) {
        lista.sort(Comparator.comparingInt(Pessoa::getIdade));
        if (!crescente) {
            Collections.reverse(lista);
        }
        return lista;
    }

    static void imprimirLista(List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa);
        }
    }
}