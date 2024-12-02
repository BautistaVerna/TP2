import java.util.Map;

public class ProcesadorPedido {
    private final Map<String, Map<String, Integer>> restaurantes;
    private final ExtractorDireccion extractorDireccion;

    public ProcesadorPedido() {
        this.restaurantes = Menu.getInstance().getRestaurantes();
        this.extractorDireccion = new ExtractorDireccion();
    }

    x

    private String buscarComida(String texto, String restaurante) {
        if (restaurante == null) return null;
        return restaurantes.get(restaurante)
                .keySet()
                .stream()
                .filter(comida -> texto.toLowerCase().contains(comida.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}