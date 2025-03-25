package Classes;

import java.util.ArrayList;
import java.util.List;

public class AreaVerde {
    private String nomeAreaVerde;
    private String idAreaVerde;
    private String coordenadasAreaVerde;
    private String vegetacaoAreaVerde;
    private String atividadesAreaVerde;
    private String horarioAreaVerde;
    private Localizacao localizacao;
    private List<Avaliacao> avaliacoes;

    public AreaVerde(String nomeAreaVerde, String coordenadasAreaVerde, String vegetacaoAreaVerde, String atividadesAreaVerde, String horarioAreaVerde, Localizacao localizacao) {
        this.nomeAreaVerde = nomeAreaVerde;
        this.idAreaVerde = idAreaVerde;
        this.coordenadasAreaVerde = coordenadasAreaVerde;
        this.vegetacaoAreaVerde = vegetacaoAreaVerde;
        this.atividadesAreaVerde = atividadesAreaVerde;
        this.horarioAreaVerde = horarioAreaVerde;
        this.localizacao = localizacao;
        this.avaliacoes = new ArrayList<>();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
            this.avaliacoes.add(avaliacao);
        }
    }

    public String getNomeAreaVerde() {
        return nomeAreaVerde;
    }

    public void setNomeAreaVerde(String nomeAreaVerde) {
        this.nomeAreaVerde = nomeAreaVerde;
    }

    public AreaVerde(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public AreaVerde() {}

    public String getIdAreaVerde() {
        return idAreaVerde;
    }

    public void setIdAreaVerde(String idAreaVerde) {
        this.idAreaVerde = idAreaVerde;
    }

    public String getCoordenadasAreaVerde() {
        return coordenadasAreaVerde;
    }

    public void setCoordenadasAreaVerde(String coordenadasAreaVerde) {
        this.coordenadasAreaVerde = coordenadasAreaVerde;
    }

    public String getVegetacaoAreaVerde() {
        return vegetacaoAreaVerde;
    }

    public void setVegetacaoAreaVerde(String vegetacaoAreaVerde) {
        this.vegetacaoAreaVerde = vegetacaoAreaVerde;
    }

    public String getAtividadesAreaVerde() {
        return atividadesAreaVerde;
    }

    public void setAtividadesAreaVerde(String atividadesAreaVerde) {
        this.atividadesAreaVerde = atividadesAreaVerde;
    }

    public String getHorarioAreaVerde() {
        return horarioAreaVerde;
    }

    public void setHorarioAreaVerde(String horarioAreaVerde) {
        this.horarioAreaVerde = horarioAreaVerde;
    }


    public double getMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            return 0.0; // Retorna 0 se não houver avaliações
        }
        double soma = 0.0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getMedia();
        }
        return soma / avaliacoes.size();
    }

    @Override
    public String toString () {
        return String.format("Informações sobre a área verde referente ao ID %s.%nNome: %s.%nCoordenadas: %s.%nVegetação: %s.%nAtividade de lazer: %s.%n" +
                        "Horário de funcionamento: %s.%nMédia das avaliações: %.2f.%n",
                 idAreaVerde, nomeAreaVerde, coordenadasAreaVerde, vegetacaoAreaVerde, atividadesAreaVerde, horarioAreaVerde, getMediaAvaliacoes());

    }
}


