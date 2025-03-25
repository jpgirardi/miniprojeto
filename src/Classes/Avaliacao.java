package Classes;

public class Avaliacao {
    private String idAvaliacao;
    private double quantidadeArvores;
    private double qualidadeDoAr;
    private double poluicaoSonora;
    private double coletaResiduos;
    private double transporte;
    private double media;

    public Avaliacao(double quantidadeArvores, double qualidadeDoAr, double poluicaoSonora, double coletaResiduos, double transporte) {
        this.quantidadeArvores = quantidadeArvores;
        this.qualidadeDoAr = qualidadeDoAr;
        this.poluicaoSonora = poluicaoSonora;
        this.coletaResiduos = coletaResiduos;
        this.transporte = transporte;
        calcularMedia();
    }

    public Avaliacao () {}

    private void calcularMedia() {
        this.media = (quantidadeArvores + qualidadeDoAr + poluicaoSonora + coletaResiduos + transporte) / 5;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(String idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public double getQuantidadeArvores() {
        return quantidadeArvores;
    }

    public void setQuantidadeArvores(double quantidadeArvores) {
        this.quantidadeArvores = quantidadeArvores;
        calcularMedia();
    }

    public double getQualidadeDoAr() {
        return qualidadeDoAr;
    }

    public void setQualidadeDoAr(double qualidadeDoAr) {
        this.qualidadeDoAr = qualidadeDoAr;
        calcularMedia();
    }

    public double getPoluicaoSonora() {
        return poluicaoSonora;
    }

    public void setPoluicaoSonora(double poluicaoSonora) {
        this.poluicaoSonora = poluicaoSonora;
        calcularMedia();
    }

    public double getColetaResiduos() {
        return coletaResiduos;
    }

    public void setColetaResiduos(double coletaResiduos) {
        this.coletaResiduos = coletaResiduos;
        calcularMedia();
    }

    public double getTransporte() {
        return transporte;
    }

    public void setTransporte(double transporte) {
        this.transporte = transporte;
        calcularMedia();
    }


    @Override
    public String toString () {
        return String.format("ID da área verde avaliada: %2s.%nQuantidade de árvores: %.2f.%nQualidade do Ar: %.2f.%nPoluição Sonora: %.2f.%n" +
                        "Coleta de resíduos: %.2f.%nFacilidade para chegar com o transporte público: %.2f.%nA nota final " +
                        "da área verde é: %.2f.%n", idAvaliacao, quantidadeArvores, qualidadeDoAr,
                poluicaoSonora, coletaResiduos, transporte, media);

    }


}


