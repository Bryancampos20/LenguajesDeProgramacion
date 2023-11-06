public class ContactoEmpresarial extends Contacto {
    private String email;

    public ContactoEmpresarial(String nombre, String apellido, String telefono, int edad, String email) {
        super(nombre, apellido, telefono, edad);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}