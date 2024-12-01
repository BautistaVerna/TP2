import java.util.HashMap;
import java.util.Map;

public class Menu {
    private static Menu instancia;
    private final Map<String, Map<String, Integer>> restaurantes;

    // Constructor privado para evitar instanciación externa
    private Menu() {
        restaurantes = new HashMap<>();
        inicializarMenu();
    }

    public static Menu getInstance() {
        if (instancia == null) {
            instancia = new Menu();
        }
        return instancia;
    }

    private void inicializarMenu() {
        // Inicialización de los menús para cada restaurante
        Map<String, Integer> fastFood = new HashMap<>();
        fastFood.put("hamburguesa", 12000);
        fastFood.put("papas fritas", 4500);
        fastFood.put("lomitos", 13000);
        fastFood.put("pancho", 4000);

        Map<String, Integer> comidaItaliana = new HashMap<>();
        comidaItaliana.put("fideos", 10000);
        comidaItaliana.put("ravioles", 11500);
        comidaItaliana.put("lasagna", 15000);
        comidaItaliana.put("ñoquis", 9500);

        Map<String, Integer> lineaVeggie = new HashMap<>();
        lineaVeggie.put("mix de ensalada", 8500);
        lineaVeggie.put("hamburguesa vegana", 12500);
        lineaVeggie.put("wok de vegetales", 9500);

        restaurantes.put("Fast Food", fastFood);
        restaurantes.put("Comida Italiana", comidaItaliana);
        restaurantes.put("Línea Veggie", lineaVeggie);
    }

    public void mostrarMenu(String restaurante) {
        if (restaurantes.containsKey(restaurante)) {
            System.out.println("Menú - " + restaurante + ":");
            restaurantes.get(restaurante).forEach((comida, precio) ->
                    System.out.println("- " + comida + " $" + precio)
            );
        } else {
            System.out.println("Restaurante no encontrado.");
        }
    }

    public Map<String, Map<String, Integer>> getRestaurantes() {
        return restaurantes;
    }
}

