package Libro_ejercicio3;

public class Alumno extends Persona {
        private String curso;

        public Alumno(String nombre, int edad, String curso) {
            super(nombre, edad);
            this.curso = curso;
        }

        @Override
        public String getInfo() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + curso;
        }
    }
