import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Clase que representa un socio de la biblioteca
public class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public int obtenerNumeroLibrosPrestados() {
        return prestamos.size();
    }

    public void prestarLibro(Libro libro, Date fechaPrestamo) {
        if (libro.estaDisponible()) {
            Prestamo prestamo = new Prestamo(libro, this, fechaPrestamo);
            prestamos.add(prestamo);
            libro.marcarComoNoDisponible();
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }
}