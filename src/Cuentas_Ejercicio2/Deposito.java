package Cuentas_Ejercicio2;

public class Deposito implements ProductoFinanciero {

        private double saldo;
        private double interesMensual;

        public Deposito(double saldo, double interesMensual) {
            this.saldo = saldo;
            this.interesMensual = interesMensual;
        }

        @Override
        public double consultarSaldo() {
            return saldo;
        }

        @Override
        public void depositar(double cantidad) {
            // No es aplicable para un CDT
        }

        @Override
        public void retirar(double cantidad) {
            // No es aplicable para un CDT
        }

        @Override
        public void cerrar() {
            // Transferir saldo más intereses a la cuenta corriente
        }
    }
