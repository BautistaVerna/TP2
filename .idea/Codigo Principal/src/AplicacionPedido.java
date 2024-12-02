import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AplicacionPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = Menu.getInstance();
        ArrayList<Pedido> ordenTotal = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {

            System.out.println("Seleccione un restaurante:");
            System.out.println("1 - Fast Food");
            System.out.println("2 - Comida Italiana");
            System.out.println("3 - Línea Veggie");
            System.out.print("Ingrese el número del restaurante: ");

            int seleccionRestaurante = scanner.nextInt();
            scanner.nextLine();

            String restauranteSeleccionado = null;
            switch (seleccionRestaurante) {
                case 1 -> restauranteSeleccionado = "Fast Food";
                case 2 -> restauranteSeleccionado = "Comida Italiana";
                case 3 -> restauranteSeleccionado = "Línea Veggie";
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
                }
            }

            boolean pedirMas = true;
            while (pedirMas) {
                System.out.println("\nMenú - " + restauranteSeleccionado + ":");
                Map<String, Integer> menuRestaurante = menu.getRestaurantes().get(restauranteSeleccionado);
                int contador = 1;

                for (Map.Entry<String, Integer> entrada : menuRestaurante.entrySet()) {
                    System.out.println(contador + " - " + entrada.getKey() + " $" + entrada.getValue());
                    contador++;
                }

                System.out.print("\nSeleccione el número de la comida que desea: ");
                int seleccionComida = scanner.nextInt();
                scanner.nextLine();

                String comidaSeleccionada = null;
                int precio = 0;
                contador = 1;

                for (Map.Entry<String, Integer> entrada : menuRestaurante.entrySet()) {
                    if (contador == seleccionComida) {
                        comidaSeleccionada = entrada.getKey();
                        precio = entrada.getValue();
                        break;
                    }
                    contador++;
                }

                if (comidaSeleccionada == null) {
                    System.out.println("Opción de comida no válida. Intente nuevamente.");
                    continue;
                }

                System.out.print("Ingrese la dirección de entrega: ");
                String direccion = scanner.nextLine();

                Pedido pedido = new Pedido(restauranteSeleccionado, comidaSeleccionada, precio, direccion);
                ordenTotal.add(pedido);

                System.out.println("\nPedido agregado a la orden:");
                pedido.mostrarResumen();

                System.out.print("\n¿Desea agregar otra comida del mismo restaurante? (1: Sí, 2: No): ");
                int opcionAgregar = scanner.nextInt();
                scanner.nextLine();

                pedirMas = (opcionAgregar == 1);
            }


            System.out.print("\n¿Desea seleccionar otro restaurante? (1: Sí, 2: No): ");
            int continuarOpc = scanner.nextInt();
            scanner.nextLine();

            continuar = (continuarOpc == 1);
        }


        if (!ordenTotal.isEmpty()) {
            System.out.println("\nResumen de su orden total:");
            for (Pedido pedido : ordenTotal) {
                pedido.mostrarResumen();
            }
            System.out.println("\n¡Gracias por su compra!");
        } else {
            System.out.println("\nNo se realizaron pedidos. ¡Gracias por utilizar la aplicación!");
        }

        scanner.close();
    }
}

