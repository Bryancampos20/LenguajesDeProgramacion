/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

/**
 *
 * @author bryan
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    public static void main(String[] args) {
        // Crear socios
        List<Socio> socios = new ArrayList<>();
        Socio socio1 = new Socio(1, "Carla Alfaro", "Cartago");
        Socio socio2 = new Socio(2, "Andrea Solis", "Puntarenas");
        Socio socio3 = new Socio(2, "Daniel Andre", "Limon");
        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);

        // Crear libros
        Libro libro1 = new Libro(101, "Libro A", "Autor X");
        Libro libro2 = new Libro(102, "Libro B", "Autor Y");
        Libro libro3 = new Libro(103, "Libro C", "Autor Z");
        Libro libro4 = new Libro(101, "Libro D", "Autor X");
        Libro libro5 = new Libro(102, "Libro 3", "Autor Y");
        Libro libro6 = new Libro(103, "Libro F", "Autor Z");
        Libro libro7 = new Libro(103, "Libro G", "Autor Z");

        // Simular préstamos
        socio1.prestarLibro(libro1, new Date());
        socio1.prestarLibro(libro2, new Date());
        socio2.prestarLibro(libro3, new Date());
        socio3.prestarLibro(libro4, new Date());
        socio3.prestarLibro(libro5, new Date());
        socio3.prestarLibro(libro6, new Date());
        socio3.prestarLibro(libro7, new Date());

        // Mostrar libros prestados por cada socio
        System.out.println("Libros prestados a " + socio1.getNombre() + ": " + socio1.obtenerNumeroLibrosPrestados());
        System.out.println("Libros prestados a " + socio2.getNombre() + ": " + socio2.obtenerNumeroLibrosPrestados());
        System.out.println("Libros prestados a " + socio3.getNombre() + ": " + socio3.obtenerNumeroLibrosPrestados());

        List<Socio> sociosConMasDe3Libros = buscarSociosConMasDe3Libros(socios);
        System.out.println("Socios con más de 3 libros prestados:");
        for (Socio socio : sociosConMasDe3Libros) {
            System.out.println("Número de socio: " + socio.getNumeroSocio() + ", Nombre: " + socio.getNombre());
        }
    }

    public static List<Socio> buscarSociosConMasDe3Libros(List<Socio> socios) {
        return socios.stream()
                .filter(socio -> socio.obtenerNumeroLibrosPrestados() > 3)
                .collect(Collectors.toList());
    }
}