package Libro_ejercicio3;

public abstract class Persona {

        protected String nombre;
        protected int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public abstract String getInfo();
    }