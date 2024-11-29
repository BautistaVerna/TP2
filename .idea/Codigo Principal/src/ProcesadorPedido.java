import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorPedido {
    private final Map<String, Map<String, Integer>> restaurantes;

    public ProcesadorPedido() {
        Menu.inicializarMenu();
        this.restaurantes = Menu.getRestaurantes();
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
        } else {
            System.out.println("No se reconoció el restaurante, comida o dirección en el texto.");
            return null;
        }
    }

    private String buscarDireccion(String texto) {
        String[] palabrasClave = {"para", "mi direccion es", "mi direccion", "hacia", "calle"};
        String[] delimitadores = {",", " del restaurante", " en ", " quiero ", " para pedir ", ".", " queria"};

        for (String palabraClave : palabrasClave) {
            if (texto.contains(palabraClave)) {
                int inicioDireccion = texto.indexOf(palabraClave) + palabraClave.length();
                String posibleDireccion = texto.substring(inicioDireccion).trim();

                Pattern patronDireccion = Pattern.compile("^[^,]*(\\d{1,5})[^,]*");
                Matcher matcher = patronDireccion.matcher(posibleDireccion);
                if (matcher.find()) {
                    String direccion = matcher.group().trim();

                    for (String delimitador : delimitadores) {
                        if (posibleDireccion.contains(delimitador)) {
                            int finDireccion = posibleDireccion.indexOf(delimitador);
                            direccion = posibleDireccion.substring(0, finDireccion).trim();
                            break;
                        }
                    }

                    return direccion;
                }
            }
        }

        return null;
    }
}