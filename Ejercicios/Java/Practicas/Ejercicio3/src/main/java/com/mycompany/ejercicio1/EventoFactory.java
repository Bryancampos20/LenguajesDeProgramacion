public class EventoFactory implements AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String apellido, String telefono, int edad, String detalles) {
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha, String detalles) {
        if (detalles.equals("Personal")) {
            return new EventoPersonal(nombre, fecha, "Detalles personales");
        } else if (detalles.equals("Empresarial")) {
            return new EventoEmpresarial(nombre, fecha, "Detalles empresariales");
        }
        return null;
    }
}