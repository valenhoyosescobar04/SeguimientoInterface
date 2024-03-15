package Libro_Ejercicio3;

import Libro_Ejercicio3.Libro;
import Libro_Ejercicio3.Printable;

import javax.swing.*;

import java.util.ArrayList;

import java.util.List;

public class LibroMain {

    private static List<Printable> items = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    ingresarLibro();
                    break;
                case 2:
                    buscarLibroPorAutor();
                    break;
                case 3:
                    buscarLibroPorPaginas();
                    break;
                case 4:
                    verTodosLosLibros();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static int mostrarMenu() {
        String[] opciones = {"Ingresar Libro", "Buscar Libro por Autor", "Buscar Libro por Páginas",
                "Ver Todos los Libros", "Eliminar Libro", "Salir"};
        return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    private static void ingresarLibro() {
        try {
            String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
            String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
            int paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas del libro:"));

            Libro libro = new Libro(titulo, autor, paginas);
            items.add((Printable) libro);

            JOptionPane.showMessageDialog(null, "Libro ingresado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número válido para el número de páginas.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el libro: " + e.getMessage());
        }
    }

    private static void buscarLibroPorAutor() {
        // Implementación de la búsqueda por autor (similar a la versión anterior)
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro a buscar:");
        boolean encontrado = false;

        for (Printable item : items) {
            if (item instanceof Libro) {
                Libro libro = (Libro) item;
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    JOptionPane.showMessageDialog(null, "Libro encontrado: \n" + libro.getInfo());
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún libro del autor especificado.");
        }
    }

}

private static void buscarLibroPorPaginas() {
    // Implementación de la búsqueda por páginas (similar a la versión anterior)
    int paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas del libro a buscar:"));
    boolean encontrado = false;

    for (Printable item : items) {
        if (item instanceof Libro) {
            Libro libro = (Libro) item;
            if (libro.getPaginas() == paginas) {
                JOptionPane.showMessageDialog(null, "Libro encontrado: \n" + libro.getInfo());
                encontrado = true;
            }
        }
    }

}

private static void verTodosLosLibros() {
    StringBuilder sb = new StringBuilder();
    for (Printable item : items) {
        if (item instanceof Libro) {
            Libro libro = (Libro) item;
            sb.append(libro.getInfo()).append("\n");
        }
    }
    if (sb.length() > 0) {
        JOptionPane.showMessageDialog(null, "Todos los libros ingresados:\n" + sb.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No hay libros ingresados.");
    }
}

private static void eliminarLibro() {
    String tituloEliminar = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
    boolean encontrado = false;

    for (int i = 0; i < items.size(); i++) {
        Printable item = items.get(i);
        if (item instanceof Libro) {
            Libro libro = (Libro) item;
            if (libro.getTitulo().equalsIgnoreCase(tituloEliminar)) {
                items.remove(i);
                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró ningún libro con el título especificado.");
    }
}
