package TiendaVirtual_Ejercicio6;

public class Pelicula extends Producto implements IProducto {
    private String protagonista;
    private String director;

    public Pelicula(String titulo, String protagonista, String director, float precio) {
        super(titulo, precio);
        this.protagonista = protagonista;
        this.director = director;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() + ", Protagonista: " + protagonista + ", Director: " + director;
    }

}
