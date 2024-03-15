package Cuentas_Ejercicio2;

public class CuentaAhorros implements ProductoFinanciero {

    private double saldo;
    private final double interesMensual = 0.006; // 0.6%

    public CuentaAhorros() {
        this.saldo = 0;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        saldo -= cantidad;
    }

    @Override
    public void cerrar() {
        // No es aplicable para una cuenta de ahorros
    }

    public void aplicarInteresMensual() {
        saldo *= (1 + interesMensual);
    }
}
