package Libro_Ejercicio3;

public abstract class Persona implements Printable {
    public void printDetails() {

    }

        protected String nombre;
        protected int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public abstract String getInfo();
    }