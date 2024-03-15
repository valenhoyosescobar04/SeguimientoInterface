package Carro_Ejercicio4;

public class Concesionario implements IConcesionario {


        private String nombre;
        private String direccion;
        private int cantidadDeCarros;

        public Concesionario(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.cantidadDeCarros = 0;
        }

        @Override
        public void agregarCarro(int cantidad) {
            cantidadDeCarros += cantidad;
        }

        @Override
        public void eliminarCarro(int cantidad) {
            cantidadDeCarros -= cantidad;
            if (cantidadDeCarros < 0) {
                cantidadDeCarros = 0;
            }
        }

        @Override
        public String getInfo() {
            return "Nombre: " + nombre + "\nDirección: " + direccion + "\nCantidad de carros disponibles: " + cantidadDeCarros;
        }

        @Override
        public boolean venderCarro(int cantidad) {
            if (cantidadDeCarros >= cantidad) {
                cantidadDeCarros -= cantidad;
                return true;
            }
            return false;
        }

        @Override
        public void mostrarCarros() {
            System.out.println("Cantidad de carros disponibles en el concesionario: " + cantidadDeCarros);
        }
    }

