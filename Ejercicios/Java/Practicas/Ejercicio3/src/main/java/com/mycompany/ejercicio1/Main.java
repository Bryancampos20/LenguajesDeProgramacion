package com.mycompany.ejercicio1;

/**
 *
 * @author bryan
 */
public class Main {
    public static void main(String[] args) {
        // Obtén la instancia de la Agenda utilizando el Singleton
        Agenda agenda = Agenda.getInstance();

        // Utiliza la AgendaFactory para crear contactos y eventos
        AgendaFactory factory = new ContactoFactory();

        Contacto contactoPersonal = factory.crearContacto("Luna", "Miranda", "70854467", 22, "Personal");
        Contacto contactoEmpresarial = factory.crearContacto("Max", "Lopez", "708904467", 25, "Empresarial");

        factory = new EventoFactory();
        Evento eventoPersonal = factory.crearEvento("Cumpleannos", "18/09/23", "Personal");
        Evento eventoEmpresarial = factory.crearEvento("Reunión Zoom", "22/10/23", "Empresarial");

        // Agregar contactos y eventos a la agenda
        agenda.agregarContacto(contactoPersonal);
        agenda.agregarContacto(contactoEmpresarial);
        agenda.agregarEvento(eventoPersonal);
        agenda.agregarEvento(eventoEmpresarial);

        // Mostrar contactos y eventos
        agenda.mostrarContactos();
        agenda.mostrarEventos();
    }
}


/*Diferencias entre un Eager Singleton y un Lazy Singleton

Eager Singleton:
- En un Eager Singleton, la instancia se crea en el momento en que la clase se carga en la memoria, es decir, en la inicialización de la aplicación o en el momento de la carga de la clase.
- Esto significa que la instancia se crea de manera temprana, incluso si no se utiliza inmediatamente, lo que puede consumir recursos innecesarios si la instancia es costosa de crear.
- Es más simple de implementar y garantiza la existencia de una única instancia en todo momento.

Lazy Singleton:
- En un Lazy Singleton, la instancia se crea solo cuando se solicita por primera vez, lo que evita la creación temprana y el consumo de recursos innecesarios.
- La instancia se crea bajo demanda y se almacena en una variable estática. Cuando se solicita la instancia, se verifica si ya existe y se devuelve la instancia existente o se crea una nueva si no existe.
- Es más eficiente en términos de recursos, pero requiere manejo de concurrencia si varias hebras intentan acceder a la instancia al mismo tiempo.

Mejor a utilizar en la implementación del problema y por qué?

Es mejor el Singlenton porque la instancia Agenda solo se creara cuando sea necesario.