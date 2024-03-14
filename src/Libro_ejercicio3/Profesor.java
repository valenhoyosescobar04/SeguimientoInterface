package Libro_ejercicio3;

public class Profesor extends Persona {

        private String materia;

        public Profesor(String nombre, int edad, String materia) {
            super(nombre, edad);
            this.materia = materia;
        }

        @Override
        public String getInfo() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Materia: " + materia;
        }
    }
