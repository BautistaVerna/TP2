import java.util.Scanner;

public class AplicacionPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcesadorPedido procesador = new ProcesadorPedido();
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú principal
            System.out.println("Seleccione un restaurante:");
            System.out.println("1 - Fast Food");
            System.out.println("2 - Comida Italiana");
            System.out.println("3 - Línea Veggie");
            System.out.print("Ingrese el número del restaurante: ");
            int seleccionRestaurante = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            // Mostrar menú del restaurante seleccionado
            switch (seleccionRestaurante) {
                case 1 -> mostrarMenu("Fast Food");
                case 2 -> mostrarMenu("Comida Italiana");
                case 3 -> mostrarMenu("Línea Veggie");
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue; // Volver al inicio del bucle
                }
            }

            // Preguntar al usuario qué desea hacer
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1 - Ver otro restaurante");
            System.out.println("2 - Ingresar pedido");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            // Procesar opciones del usuario
            if (opcion == 2) {
                System.out.print("Ingrese su pedido (por ejemplo: 'Quiero pedir una hamburguesa'): ");
                String textoDePedido = scanner.nextLine();
                Pedido pedido = procesador.procesarPedido(textoDePedido);

                if (pedido != null) {
                    pedido.mostrarResumen(); // Mostrar resumen del pedido
                    System.out.print("Seleccione una opción (1: Confirmar, 2: Modificar): ");
                    int confirmacion = scanner.nextInt();
                    pedido.procesarOpcion(confirmacion);
                }
                continuar = false; // Salir del bucle después de ingresar un pedido
            } else if (opcion != 1) {
                System.out.println("Opción no válida. Volviendo al menú principal...");
            }
        }

        scanner.close();
    }

    // Método para mostrar el menú de un restaurante
    private static void mostrarMenu(String restaurante) {
        switch (restaurante) {
            case "Fast Food" -> {
                System.out.println("Menú - Fast Food:");
                System.out.println("- Hamburguesa $12,000");
                System.out.println("- Papas fritas $4,500");
                System.out.println("- Lomitos $13,000");
                System.out.println("- Pancho $4,000");
            }
            case "Comida Italiana" -> {
                System.out.println("Menú - Comida Italiana:");
                System.out.println("- Fideos $10,000");
                System.out.println("- Ravioles $11,500");
                System.out.println("- Lasagna $15,000");
                System.out.println("- Ñoquis $9,500");
            }
            case "Línea Veggie" -> {
                System.out.println("Menú - Línea Veggie:");
                System.out.println("- Mix de ensalada $8,500");
                System.out.println("- Hamburguesa vegana $12,500");
                System.out.println("- Wok de vegetales $9,500");
            }
        }
    }
}

