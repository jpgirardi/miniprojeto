package Classes;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {
    public static final List<Avaliacao> listaAvaliacoes = new ArrayList<>();
    private static int contadorId = 1;



    public static void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
            avaliacao.setIdAvaliacao(String.valueOf(contadorId));
            listaAvaliacoes.add(avaliacao);
            contadorId++;
        }
    }


    public static void removerAvaliacao(Avaliacao avaliacao) {
        listaAvaliacoes.remove(avaliacao);
    }


    public static List<Avaliacao> getAvaliacoes() {
        return listaAvaliacoes;
    }


    public static Avaliacao buscarPorId(String id) {
        for (Avaliacao avaliacao : listaAvaliacoes) {
            if (avaliacao.getIdAvaliacao().equals(id)) {
                return avaliacao;
            }
        }
        return null; // Retorna null se não encontrar
    }


    public static void limparAvaliacoes() {
        listaAvaliacoes.clear();
    }
}