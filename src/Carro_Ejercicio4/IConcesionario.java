package Carro_Ejercicio4;

public interface IConcesionario {
    void agregarCarro(int cantidad);
    void eliminarCarro(int cantidad);
    String getInfo();
    boolean venderCarro(int cantidad);
    void mostrarCarros();
}
