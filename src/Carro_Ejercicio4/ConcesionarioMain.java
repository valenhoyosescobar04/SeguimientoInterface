package Carro_Ejercicio4;

import javax.swing.*;

import java.util.ArrayList;

public class ConcesionarioMain {

        private static ArrayList<Concesionario> concesionarios = new ArrayList<>();

        public static void main(String[] args) {
            while (true) {
                int opcion = mostrarMenu();

                switch (opcion) {
                    case 1:
                        agregarConcesionario();
                        break;
                    case 2:
                        eliminarConcesionario();
                        break;
                    case 3:
                        mostrarInfoConcesionarios();
                        break;
                    case 4:
                        agregarCarros();
                        break;
                    case 5:
                        venderCarro();
                        break;
                    case 6:
                        mostrarCarrosDisponibles();
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Gracias por usar nuestro sistema.");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        }

        private static int mostrarMenu() {
            String[] opciones = {
                    "Agregar concesionario",
                    "Eliminar concesionario",
                    "Mostrar información de los concesionarios",
                    "Agregar carros",
                    "Vender carro",
                    "Mostrar cantidad de carros disponibles",
                    "Salir"
            };
            return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        }

        private static void agregarConcesionario() {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del concesionario:");
            String direccion = JOptionPane.showInputDialog("Ingrese la dirección del concesionario:");
            Concesionario concesionario = new Concesionario(nombre, direccion);
            concesionarios.add(concesionario);
            JOptionPane.showMessageDialog(null, "Concesionario agregado con éxito.");
        }

        private static void eliminarConcesionario() {
            if (concesionarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay concesionarios para eliminar.");
                return;
            }
            String[] nombresConcesionarios = new String[concesionarios.size()];
            for (int i = 0; i < concesionarios.size(); i++) {
                nombresConcesionarios[i] = concesionarios.get(i).getInfo();
            }
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el concesionario a eliminar:", "Eliminar Concesionario", JOptionPane.DEFAULT_OPTION, null, nombresConcesionarios, nombresConcesionarios[0]);
            for (Concesionario concesionario : concesionarios) {
                if (concesionario.getInfo().equals(seleccion)) {
                    concesionarios.remove(concesionario);
                    JOptionPane.showMessageDialog(null, "Concesionario eliminado con éxito.");
                    return;
                }
            }
        }

        private static void mostrarInfoConcesionarios() {
            StringBuilder sb = new StringBuilder("Información de los concesionarios:\n");
            for (Concesionario concesionario : concesionarios) {
                sb.append(concesionario.getInfo()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        private static void agregarCarros() {
            if (concesionarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay concesionarios para agregar carros.");
                return;
            }
            String[] nombresConcesionarios = new String[concesionarios.size()];
            for (int i = 0; i < concesionarios.size(); i++) {
                nombresConcesionarios[i] = concesionarios.get(i).getInfo();
            }
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el concesionario para agregar carros:", "Agregar Carros", JOptionPane.DEFAULT_OPTION, null, nombresConcesionarios, nombresConcesionarios[0]);
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de carros a agregar:"));
            for (Concesionario concesionario : concesionarios) {
                if (concesionario.getInfo().equals(seleccion)) {
                    concesionario.agregarCarro(cantidad);
                    JOptionPane.showMessageDialog(null, "Carros agregados con éxito al concesionario.");
                    return;
                }
            }
        }

        private static void venderCarro() {
            if (concesionarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay concesionarios disponibles para vender carros.");
                return;
            }
            String[] nombresConcesionarios = new String[concesionarios.size()];
            for (int i = 0; i < concesionarios.size(); i++) {
                nombresConcesionarios[i] = concesionarios.get(i).getInfo();
            }
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el concesionario para vender carro:", "Vender Carro", JOptionPane.DEFAULT_OPTION, null, nombresConcesionarios, nombresConcesionarios[0]);
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de carros a vender:"));
            for (Concesionario concesionario : concesionarios) {
                if (concesionario.getInfo().equals(seleccion)) {
                    if (concesionario.venderCarro(cantidad)) {
                        JOptionPane.showMessageDialog(null, "Venta de carro realizada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay suficientes carros en el concesionario para realizar la venta.");
                    }
                    return;
                }
            }
        }

        private static void mostrarCarrosDisponibles() {
            if (concesionarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay concesionarios disponibles para mostrar carros.");
                return;
            }
            StringBuilder sb = new StringBuilder("Cantidad de carros disponibles en cada concesionario:\n");
            for (Concesionario concesionario : concesionarios) {
                sb.append(concesionario.getInfo()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

