package Cuentas_Ejercicio2;

public interface ProductoFinanciero {
    double consultarSaldo();
    void depositar(double cantidad);
    void retirar(double cantidad);
    void cerrar();
}
