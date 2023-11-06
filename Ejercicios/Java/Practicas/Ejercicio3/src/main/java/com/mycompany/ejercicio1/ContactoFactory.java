public class ContactoFactory implements AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String apellido, String telefono, int edad, String detalles) {
        if (detalles.equals("Personal")) {
            return new ContactoPersonal(nombre, apellido, telefono, edad, "Detalles personales");
        } else if (detalles.equals("Empresarial")) {
            return new ContactoEmpresarial(nombre, apellido, telefono, edad, "Detalles empresariales");
        }
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha, String detalles) {
        return null;
    }
}
