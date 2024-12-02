public class ExtractorDireccion {
    public String buscarDireccion(String texto) {
        // Buscar la palabra clave "Dirección:"
        String palabraClave = "\"para\", \"mi direccion es\", \"en\", \"hacia\", \"calle\":";
        if (texto.contains(palabraClave)) {
            int inicio = texto.indexOf(palabraClave) + palabraClave.length();
            String subTexto = texto.substring(inicio).trim();

            // Dividir el subtexto en partes usando delimitadores comunes como , . ; \n \t y 'y'
            String[] partes = subTexto.split("[,\\.\\s]+|gracias|;|\\n|\\t|y");

            // Devolver la primera parte que no esté vacía
            if (partes.length > 0) {
                for (String parte : partes) {
                    if (!parte.trim().isEmpty()) {
                        return parte.trim();
                    }
                }
            }
        }
        return "Dirección no encontrada"; // Mensaje si no se encuentra la dirección
    }
}
