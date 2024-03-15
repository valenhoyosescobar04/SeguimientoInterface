package TiendaVirtual_Ejercicio6;

import javax.swing.*;

import java.util.ArrayList;

public class ProductoMain {

        private static ArrayList<IProducto> productos = new ArrayList<>();
        private static float totalVentas = 0;

        public static void main(String[] args) {
            // Crear libros y películas
            Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", 20.99f);
            Libro libro2 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 15.50f);
            Pelicula pelicula1 = new Pelicula("Inception", "Leonardo DiCaprio", "Christopher Nolan", 25.99f);
            Pelicula pelicula2 = new Pelicula("The Dark Knight", "Christian Bale", "Christopher Nolan", 19.99f);

            // Agregar productos al ArrayList
            productos.add(libro1);
            productos.add(libro2);
            productos.add(pelicula1);
            productos.add(pelicula2);

            // Imprimir listado de productos disponibles
            imprimirProductos();

            // Registrar ventas
            comprarProducto();

            // Imprimir total de ventas
            JOptionPane.showMessageDialog(null, "Total de ventas realizadas: $" + totalVentas);
        }

        private static void imprimirProductos() {
            StringBuilder sb = new StringBuilder("Productos disponibles:\n");
            for (int i = 0; i < productos.size(); i++) {
                sb.append(i + 1).append(". ").append(productos.get(i).toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        private static void comprarProducto() {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el número de la película que desea comprar:"));

                if (opcion < 1 || opcion > productos.size()) {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione un número válido.");
                    return;
                }

                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de entradas que desea comprar:"));
                IProducto producto = productos.get(opcion - 1);
                totalVentas += producto.getPrecio() * cantidad;
                JOptionPane.showMessageDialog(null, "Compra realizada: " + producto.getTitulo() + " - " + cantidad + " entradas compradas por $" + (producto.getPrecio() * cantidad));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido para la opción y la cantidad.");
            }
        }
    }

