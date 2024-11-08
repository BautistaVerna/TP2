import java.util.HashMap;
import java.util.Map;

public class Menu {
    private static final Map<String, Map<String, Integer>> restaurantes = new HashMap<>();

    // Inicializa las opciones de comida y precios para cada restaurante
    public static void inicializarMenu() {
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
        restaurantes.put("Linea Veggie", lineaVeggie);
    }

    // Método para obtener los restaurantes y sus comidas
    public static Map<String, Map<String, Integer>> getRestaurantes() {
        return restaurantes;
    }
}
