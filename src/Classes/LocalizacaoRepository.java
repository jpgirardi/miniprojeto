package Classes;

import java.util.ArrayList;
import java.util.List;

public class LocalizacaoRepository {

    public static final List<Localizacao> listaLocalizacoes = new ArrayList<>();
    private static int contadorId = 1;


    public static void adicionarLocalizacao(Localizacao localizacao) {
        if (localizacao != null) {
            localizacao.setId(String.valueOf(contadorId));
            listaLocalizacoes.add(localizacao);
            contadorId++;
        }
    }


    public static void removerLocalizacao(Localizacao localizacao) {
        listaLocalizacoes.remove(localizacao);
    }


    public static List<Localizacao> getLocalizacoes() {
        return listaLocalizacoes;
    }


    public static Localizacao buscarPorId(String id) {
        for (Localizacao localizacao : listaLocalizacoes) {
            if (localizacao.getId().equals(id)) {
                return localizacao;
            }
        }
        return null;
    }


    public static void limparLocalizacoes() {
        listaLocalizacoes.clear();
    }
}