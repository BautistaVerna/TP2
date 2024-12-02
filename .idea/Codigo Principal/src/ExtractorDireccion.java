public String buscarDireccion(String texto) {
    String[] palabrasClave = {"para", "mi direccion es", "en", "hacia", "calle"};
    String[] delimitadoresFinales = {",", "\\.", "gracias", "quiero", "y", "me gustaria"};

    for (String clave : palabrasClave) {
        if (texto.contains(clave)) {
            int inicio = texto.indexOf(clave) + clave.length();
            String subcadena = texto.substring(inicio).trim();

            // Buscar el delimitador final más cercano
            for (String delimitador : delimitadoresFinales) {
                int fin = subcadena.indexOf(delimitador);
                if (fin != -1) {
                    return subcadena.substring(0, fin).trim();
                }
            }

            // Si no encuentra delimitadores finales, devuelve toda la subcadena
            return subcadena;
        }
    }
    return null; // Si no encuentra palabras clave, retorna null
}
