import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private List<Evento> eventos;
    private static Agenda instance;

    private Agenda() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public static Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
    public void eliminarEvento(Evento evento) {
        eventos.remove(evento);
    }

    public void modificarContacto(Contacto contactoActual, Contacto contactoNuevo) {
        int pos = contactos.indexOf(contactoActual);
        if(pos != -1){
            contactos.set(pos,contactoNuevo);
        }
    }

    public void modificarEvento(Evento eventoActual, Evento eventoNuevo) {
        int pos = eventos.indexOf(eventoActual);
        if(pos != -1) {
            eventos.set(pos,eventoNuevo);
        }
    }

    public void mostrarContactos() {
        System.out.println("Contactos actuales:");
        for(Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void mostrarEventos() {
        System.out.println("Eventos actuales:");
        for(Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}