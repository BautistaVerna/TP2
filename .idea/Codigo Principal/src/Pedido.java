public class Pedido {
    private String restaurante;
    private String comida;
    private int precio;
    private String direccion;

    public Pedido(String restaurante, String comida, int precio, String direccion) {
        this.restaurante = restaurante;
        this.comida = comida;
        this.precio = precio;
        this.direccion = direccion;
    }

    public void mostrarResumen() {
        System.out.println("Resumen de tu pedido:");
        System.out.println("Restaurante: " + restaurante);
        System.out.println("Comida: " + comida);
        System.out.println("Dirección: " + direccion);
        System.out.println("Precio: $" + precio);
        System.out.println();
        System.out.println("1 - Confirmar y enviar pedido");
        System.out.println("2 - Grabar nuevo audio");
        System.out.print("Seleccione una opción: ");
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> System.out.println("Pedido confirmado y enviado. ¡Gracias por su compra!");
            case 2 -> System.out.println("Grabando nuevo audio...");
            default -> System.out.println("Opción no válida.");
        }
    }
}
