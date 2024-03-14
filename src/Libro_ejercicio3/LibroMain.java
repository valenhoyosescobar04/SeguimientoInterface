package Libro_ejercicio3;

import javax.swing.*;

import java.util.ArrayList;

public class LibroMain {

        public static void main(String[] args) {
            ArrayList<Printable> items = new ArrayList<>();

            // Ventana para ingresar información del libro
            String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
            String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
            int paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas del libro:"));

            Libro libro = new Libro(titulo, autor, paginas);
            items.add(libro);

            // Ventana para ingresar información del alumno
            String nombreAlumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
            int edadAlumno = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno:"));
            String cursoAlumno = JOptionPane.showInputDialog("Ingrese el curso del alumno:");

            Alumno alumno = new Alumno(nombreAlumno, edadAlumno, cursoAlumno);
            items.add(alumno);

            // Ventana para ingresar información del profesor
            String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");
            int edadProfesor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del profesor:"));
            String materiaProfesor = JOptionPane.showInputDialog("Ingrese la materia que enseña el profesor:");

            Profesor profesor = new Profesor(nombreProfesor, edadProfesor, materiaProfesor);
            items.add(profesor);

            // Imprimir los detalles de todos los objetos
            System.out.println("Detalles de los objetos ingresados:");
            for (Printable item : items) {
                item.printDetails();
                System.out.println();
            }
        }
    }

