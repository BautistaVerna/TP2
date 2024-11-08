import java.util.Map;

public class ProcesadorPedido {
    private final Map<String, Map<String, Integer>> restaurantes;

    public ProcesadorPedido() {
        Menu.inicializarMenu();
        this.restaurantes = Menu.getRestaurantes();
    }

    // Procesa el texto y busca coincidencias para restaurante y comida de forma flexible
    public Pedido procesarPedido(String texto) {
        String restauranteSeleccionado = null;
        String comidaSeleccionada = null;
        int precioComida = 0;

        texto = texto.toLowerCase();

        // Buscar coincidencia con el nombre de un restaurante en el texto
        for (String restaurante : restaurantes.keySet()) {
            if (texto.contains(restaurante.toLowerCase())) {
                restauranteSeleccionado = restaurante;
                break;
            }
        }

        // Si se encuentra un restaurante, buscar una coincidencia de comida dentro de ese restaurante
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

        // Verificar si se ha encontrado tanto restaurante como comida
        if (restauranteSeleccionado != null && comidaSeleccionada != null) {
            return new Pedido(restauranteSeleccionado, comidaSeleccionada, precioComida);
        } else {
            System.out.println("No se reconoció el restaurante o la comida en el texto.");
            return null;
        }
    }
}
