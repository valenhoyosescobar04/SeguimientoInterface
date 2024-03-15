package Cuentas_Ejercicio2;

public class CuentaCorriente implements ProductoFinanciero {

        private double saldo;

        public CuentaCorriente() {
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
            // No es aplicable para una cuenta corriente
        }
    }
