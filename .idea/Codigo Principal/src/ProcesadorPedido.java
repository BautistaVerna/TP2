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

        texto = texto.toLowerCase(); // Convertir todo el texto a minúsculas para facilitar la comparación

        // Buscar coincidencia con el nombre de un restaurante
        for (String restaurante : restaurantes.keySet()) {
            if (texto.contains(restaurante.toLowerCase())) {
                restauranteSeleccionado = restaurante;
                break;
            }
        }

        // Si se encuentra un restaurante, buscar una coincidencia de comida
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

        // Detectar la dirección basándose en palabras clave
        direccion = buscarDireccion(texto);

        // Verificar si se ha encontrado todo (restaurante, comida y dirección)
        if (restauranteSeleccionado != null && comidaSeleccionada != null && direccion != null) {
            return new Pedido(restauranteSeleccionado, comidaSeleccionada, precioComida, direccion);
        } else {
            System.out.println("No se reconoció el restaurante, comida o dirección en el texto.");
            return null;
        }
    }

    private String buscarDireccion(String texto) {
        // Palabras clave para detectar direcciones
        String[] palabrasClave = {"para", "mi direccion es", "mi direccion", "hacia", "calle"};
        String[] delimitadores = {",", " del restaurante", " en ", " quiero ", " para pedir "}; // Delimitadores que indican el fin de la dirección

        for (String palabraClave : palabrasClave) {
            if (texto.contains(palabraClave)) {
                // Capturar la parte del texto después de la palabra clave
                int inicioDireccion = texto.indexOf(palabraClave) + palabraClave.length();
                String posibleDireccion = texto.substring(inicioDireccion).trim();

                // Verificar si la dirección incluye un número (indicador de dirección válida)
                Pattern patronDireccion = Pattern.compile("^[^,]*(\\d{1,5})[^,]*"); // Detectar hasta el número
                Matcher matcher = patronDireccion.matcher(posibleDireccion);
                if (matcher.find()) {
                    String direccion = matcher.group().trim();

                    // Recortar la dirección si hay un delimitador después de esta
                    for (String delimitador : delimitadores) {
                        if (posibleDireccion.contains(delimitador)) {
                            int finDireccion = posibleDireccion.indexOf(delimitador);
                            direccion = posibleDireccion.substring(0, finDireccion).trim();
                            break;
                        }
                    }

                    return direccion; // Retornar solo la dirección detectada
                }
            }
        }

        return null; // Si no se detecta dirección, retornar null
    }



}

