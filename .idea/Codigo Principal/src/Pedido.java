public class Pedido {
    private final String restaurante;
    private final String comida;
    private final int precio;
    private final String direccion;

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
    }
}
