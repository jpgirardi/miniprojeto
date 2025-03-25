package Classes;

import java.util.ArrayList;
import java.util.List;

public class AreaVerdeRepository {
    private static final List<AreaVerde> AREAS_VERDES = new ArrayList<>();

    public static void adicionarAreaVerde(AreaVerde areaVerde) {
        if (areaVerde != null) {
            areaVerde.setIdAreaVerde(String.valueOf(AREAS_VERDES.size() + 1));
            AREAS_VERDES.add(areaVerde);
        }
    }


    public List<AreaVerde> listarAreasVerdes() {
        return AREAS_VERDES;
    }

    public static double calcularSomaAvaliacoes(){
        double soma = 0;
        for (AreaVerde areaVerde : AREAS_VERDES) {
            soma += areaVerde.getMediaAvaliacoes();
        }
        return soma;
    }

    public static double calcularMediaAvaliacoes(){
        double media = 0;
        if (AREAS_VERDES.isEmpty()){
            return 0;
        }
        return calcularSomaAvaliacoes() / AREAS_VERDES.size();
    }

    public AreaVerde buscarPorId(String id) {
        if (id == null) {
            return null;
        }
        for (AreaVerde areaVerde : AREAS_VERDES) {
            if (id.equals(areaVerde.getIdAreaVerde())) {
                return areaVerde;
            }
        }
        return null;
    }


    public void limparAreasVerdes() {
        AREAS_VERDES.clear();
    }
}