package Classes;

public class Localizacao {
    private String id;
    private String coordenadas;
    private String identificador;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString () {
        return String.format("ID Área Verde: %s.%nCoordenadas da Área Verde: %s.%nIdentificador: %s.%n",
                id, coordenadas, identificador);

    }
}
