import java.util.Map;

public class ProcesadorPedido {
    private final Map<String, Map<String, Integer>> restaurantes;
    private final ExtractorDireccion extractorDireccion;

    public ProcesadorPedido() {
        this.restaurantes = Menu.getInstance().getRestaurantes();
        this.extractorDireccion = new ExtractorDireccion();
    }

    public Pedido procesarPedido(String texto) {
        String restauranteSeleccionado = buscarRestaurante(texto);
        String comidaSeleccionada = buscarComida(texto, restauranteSeleccionado);
        String direccion = extractorDireccion.buscarDireccion(texto);

        if (restauranteSeleccionado != null && comidaSeleccionada != null && direccion != null) {
            int precioComida = restaurantes.get(restauranteSeleccionado).get(comidaSeleccionada);
            return new Pedido(restauranteSeleccionado, comidaSeleccionada, precioComida, direccion);
        }
        return null;
    }

    private String buscarRestaurante(String texto) {
        return restaurantes.keySet()
                .stream()
                .filter(restaurante -> texto.toLowerCase().contains(restaurante.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

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