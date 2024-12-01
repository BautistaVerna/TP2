public class ExtractorDireccion {
    public String buscarDireccion(String texto) {
        String[] palabrasClave = {"para", "mi direccion es", "en", "hacia", "calle"};
        for (String clave : palabrasClave) {
            if (texto.contains(clave)) {
                int inicio = texto.indexOf(clave) + clave.length();
                return texto.substring(inicio).split(",|\\.|\\s+gracias")[0].trim();
            }
        }
        return null;
    }
}