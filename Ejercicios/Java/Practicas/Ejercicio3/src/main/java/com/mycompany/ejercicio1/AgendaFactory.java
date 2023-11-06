public interface AgendaFactory {
    Contacto crearContacto(String nombre, String apellido, String telefono, int edad, String detalles);
    Evento crearEvento(String nombre, String fecha, String detalles);
}