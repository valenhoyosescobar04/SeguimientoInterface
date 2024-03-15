package TiendaVirtual_Ejercicio6;

public class Libro extends Producto implements IProducto {
    private String autor;

    public Libro(String titulo, String autor, float precio) {
        super(titulo, precio);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autor: " + autor;
    }

}
