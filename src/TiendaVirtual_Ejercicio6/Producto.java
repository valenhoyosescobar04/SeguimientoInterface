package TiendaVirtual_Ejercicio6;

public class Producto {
    protected String titulo;
    protected float precio;

    public Producto(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Precio: " + precio;
    }
}

