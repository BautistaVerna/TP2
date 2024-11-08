import java.util.Scanner;

public class AplicacionPedido {
    public static void main(String[] args) {
        // Inicializar el escáner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia del procesador de pedidos
        ProcesadorPedido procesador = new ProcesadorPedido();

        // Mostrar menú de restaurantes
        System.out.println("Seleccione un restaurante:");
        System.out.println("1 - Fast Food");
        System.out.println("2 - Comida Italiana");
        System.out.println("3 - Linea Veggie");
        System.out.print("Ingrese el número del restaurante: ");
        int seleccionRestaurante = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        // Mostrar platos según la selección del restaurante
        switch (seleccionRestaurante) {
            case 1 -> {
                System.out.println("Platos en Fast Food:");
                System.out.println("Hamburguesa $12000");
                System.out.println("Papas fritas $4500");
                System.out.println("Lomitos $13000");
                System.out.println("Pancho $4000");
            }
            case 2 -> {
                System.out.println("Platos en Comida Italiana:");
                System.out.println("Fideos $10000");
                System.out.println("Ravioles $11500");
                System.out.println("Lasagna $15000");
                System.out.println("Ñoquis $9500");
            }
            case 3 -> {
                System.out.println("Platos en Linea Veggie:");
                System.out.println("Mix de ensalada $8500");
                System.out.println("Hamburguesa vegana $12500");
                System.out.println("Wok de vegetales $9500");
            }
            default -> {
                System.out.println("Opción no válida.");
                scanner.close();
                return;
            }
        }

        // Solicitar al usuario que ingrese su pedido
        System.out.println("Ingrese su pedido (por ejemplo: 'Quiero pedir una hamburguesa'): ");
        String textoDePedido = scanner.nextLine();

        // Procesar el texto del pedido ingresado
        Pedido pedido = procesador.procesarPedido(textoDePedido);

        // Verificar si el pedido se ha identificado correctamente
        if (pedido != null) {
            pedido.mostrarResumen();
            int opcion = scanner.nextInt();
            pedido.procesarOpcion(opcion);
        }

        // Cerrar el escáner
        scanner.close();
    }
}
