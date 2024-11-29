import java.util.Scanner;

public class AplicacionPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcesadorPedido procesador = new ProcesadorPedido();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione un restaurante:");
            System.out.println("1 - Fast Food");
            System.out.println("2 - Comida Italiana");
            System.out.println("3 - Línea Veggie");
            System.out.print("Ingrese el número del restaurante: ");
            int seleccionRestaurante = scanner.nextInt();
            scanner.nextLine();

            switch (seleccionRestaurante) {
                case 1 -> mostrarMenu("Fast Food");
                case 2 -> mostrarMenu("Comida Italiana");
                case 3 -> mostrarMenu("Línea Veggie");
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
                }
            }

            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1 - Ver otro restaurante");
            System.out.println("2 - Ingresar pedido");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 2) {
                boolean modificar = true;

                while (modificar) {
                    System.out.print("Ingrese su pedido, indicando restaurante, menu y direccion");
                    String textoDePedido = scanner.nextLine();
                    Pedido pedido = procesador.procesarPedido(textoDePedido);

                    if (pedido != null) {
                        pedido.mostrarResumen();

                        System.out.print("Seleccione una opción (1: Confirmar, 2: Modificar): ");
                        int confirmacion = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmacion == 1) {
                            System.out.println("Pedido confirmado y enviado. ¡Gracias por su compra!");
                            modificar = false;
                            continuar = false;
                        } else if (confirmacion == 2) {
                            System.out.println("Modificando pedido... Ingrese nuevamente los detalles.");
                        } else {
                            System.out.println("Opción no válida. Intentando nuevamente.");
                        }
                    } else {
                        System.out.println("No se reconoció el pedido. Por favor, intente nuevamente.");
                    }
                }
            } else if (opcion != 1) {
                System.out.println("Opción no válida. Volviendo al menú principal...");
            }
        }

        scanner.close();
    }

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