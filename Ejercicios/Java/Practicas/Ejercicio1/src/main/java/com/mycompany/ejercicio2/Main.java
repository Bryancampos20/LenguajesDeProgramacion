/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

/**
 *
 * @author bryan
 */
public class Main {

    public static void main(String[] args) {
        // Crear un documento
        Documento documento = new Documento();

        // Crear hojas
        Hoja hoja1 = new Hoja();
        Hoja hoja2 = new Hoja();

        // Crear objetos representables
        Circulo circulo1 = new Circulo(4);
        Circulo circulo2 = new Circulo(10);
        Linea linea1 = new Linea(6);
        Linea linea2 = new Linea(18);
        Rectangulo rectangulo1 = new Rectangulo(5, 7);
        Rectangulo rectangulo2 = new Rectangulo(4, 2);
        Texto texto1 = new Texto("Este es el texto #1");

        // Crear un grupo y agregar objetos
        Grupo grupo1 = new Grupo();
        grupo1.agregarObjeto(circulo1);
        grupo1.agregarObjeto(linea1);

        // Agregar objetos a las hojas
        hoja1.agregarObjeto(circulo2);
        hoja1.agregarObjeto(linea2);
        hoja1.agregarObjeto(rectangulo2);
        hoja2.agregarObjeto(grupo1);
        hoja2.agregarObjeto(rectangulo1);
        hoja2.agregarObjeto(texto1);

        // Agregar hojas al documento
        documento.agregarHoja(hoja1);
        documento.agregarHoja(hoja2);

        // Imprimir el contenido del documento
        documento.imprimirDocumento();
    }
}