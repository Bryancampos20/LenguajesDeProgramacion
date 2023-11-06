/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

/**
 *
 * @author bryan
 */
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        ContactoPersonal contactoPersonal = new ContactoPersonal("Luna", "Miranda", "70854467",22, "San Jose, Costa Rica");
        ContactoEmpresarial contactoEmpresarial = new ContactoEmpresarial("Max", "Lopez", "708904467", 25, "max.lopez@example.com");

        EventoPersonal eventoPersonal = new EventoPersonal("Cumpleannos", "18/09/23", "Restaurante Example");
        EventoEmpresarial eventoEmpresarial = new EventoEmpresarial("Reunión Zoom", "22/10/23", "Obligatoria");

        agenda.agregarContacto(contactoPersonal);
        agenda.agregarContacto(contactoEmpresarial);
        agenda.agregarEvento(eventoPersonal);
        agenda.agregarEvento(eventoEmpresarial);

        agenda.mostrarContactos();

        agenda.mostrarEventos();
    }
}