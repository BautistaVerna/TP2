import java.util.Map;

public class ProcesadorPedido {
    private final Map<String, Map<String, Integer>> restaurantes;

    public ProcesadorPedido() {
        this.restaurantes = Menu.getInstance().getRestaurantes();
    }

    public Pedido procesarPedido(String texto) {
        String restauranteSeleccionado = null;
        String comidaSeleccionada = null;
        String direccion = null;
        int precioComida = 0;

        texto = texto.toLowerCase();

        for (String restaurante : restaurantes.keySet()) {
            if (texto.contains(restaurante.toLowerCase())) {
                restauranteSeleccionado = restaurante;
                break;
            }
        }

        if (restauranteSeleccionado != null) {
            Map<String, Integer> comidas = restaurantes.get(restauranteSeleccionado);
            for (Map.Entry<String, Integer> entrada : comidas.entrySet()) {
                if (texto.contains(entrada.getKey().toLowerCase())) {
                    comidaSeleccionada = entrada.getKey();
                    precioComida = entrada.getValue();
                    break;
                }
            }
        }

        direccion = buscarDireccion(texto);

        if (restauranteSeleccionado != null && comidaSeleccionada != null && direccion != null) {
            return new Pedido(restauranteSeleccionado, comidaSeleccionada, precioComida, direccion);
        }
        return null;
    }

    private String buscarDireccion(String texto) {
        String[] palabrasClave = {"para", "mi direccion es", "en", "hacia", "calle"};
        for (String clave : palabrasClave) {
            if (texto.contains(clave)) {
                int inicio = texto.indexOf(clave) + clave.length();
                return texto.substring(inicio).split(",|\\.|\\s+gracias")[0].trim();
            }
        }
        return null;
    }
}
