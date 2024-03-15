package Cuentas_Ejercicio2;

import javax.swing.*;

import java.util.ArrayList;

public class FinanzasMain {

        private static ArrayList<ProductoFinanciero> productos = new ArrayList<>();

        public static void main(String[] args) {
            while (true) {
                int opcion = mostrarMenu();

                switch (opcion) {
                    case 1:
                        visualizarSaldoCuentaCorriente();
                        break;
                    case 2:
                        visualizarSaldoCuentaAhorros();
                        break;
                    case 3:
                        visualizarSaldoCDT();
                        break;
                    case 4:
                        visualizarSaldoTotal();
                        break;
                    case 5:
                        invertirEnCDT();
                        break;
                    case 6:
                        cerrarCDT();
                        break;
                    case 7:
                        consignarEnCuentaCorriente();
                        break;
                    case 8:
                        retirarDeCuentaCorriente();
                        break;
                    case 9:
                        consignarEnCuentaAhorros();
                        break;
                    case 10:
                        retirarDeCuentaAhorros();
                        break;
                    case 11:
                        JOptionPane.showMessageDialog(null, "Gracias por usar nuestro sistema.");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        }

        private static int mostrarMenu() {
            String[] opciones = {
                    "Visualizar saldo cuenta corriente",
                    "Visualizar saldo cuenta de ahorros",
                    "Visualizar saldo CDT",
                    "Visualizar saldo total",
                    "Invertir en CDT",
                    "Cerrar CDT",
                    "Consignar en cuenta corriente",
                    "Retirar de cuenta corriente",
                    "Consignar en cuenta de ahorros",
                    "Retirar de cuenta de ahorros",
                    "Salir"
            };
            return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        }

        private static void visualizarSaldoCuentaCorriente() {
            double saldo = 0;
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaCorriente) {
                    saldo += producto.consultarSaldo();
                }
            }
            JOptionPane.showMessageDialog(null, "Saldo de cuenta corriente: $" + saldo);
        }

        private static void visualizarSaldoCuentaAhorros() {
            double saldo = 0;
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaAhorros) {
                    saldo += producto.consultarSaldo();
                }
            }
            JOptionPane.showMessageDialog(null, "Saldo de cuenta de ahorros: $" + saldo);
        }

        private static void visualizarSaldoCDT() {
            double saldo = 0;
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof Deposito) {
                    saldo += producto.consultarSaldo();
                }
            }
            JOptionPane.showMessageDialog(null, "Saldo de CDT: $" + saldo);
        }

        private static void visualizarSaldoTotal() {
            double saldoTotal = 0;
            for (ProductoFinanciero producto : productos) {
                saldoTotal += producto.consultarSaldo();
            }
            JOptionPane.showMessageDialog(null, "Saldo total: $" + saldoTotal);
        }

        private static void invertirEnCDT() {
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a invertir:"));
            double interes = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el interés mensual del CDT:"));
            Deposito deposito = new Deposito(monto, interes);
            productos.add(deposito);
            JOptionPane.showMessageDialog(null, "Inversión en CDT realizada con éxito.");
        }

        private static void cerrarCDT() {
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof Deposito) {
                    producto.cerrar();
                    productos.remove(producto);
                    JOptionPane.showMessageDialog(null, "CDT cerrado con éxito.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No hay CDTs abiertos para cerrar.");
        }

        private static void consignarEnCuentaCorriente() {
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a consignar:"));
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaCorriente) {
                    producto.depositar(cantidad);
                    JOptionPane.showMessageDialog(null, "Consignación realizada en cuenta corriente con éxito.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró la cuenta corriente del cliente.");
        }

        private static void retirarDeCuentaCorriente() {
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaCorriente) {
                    producto.retirar(cantidad);
                    JOptionPane.showMessageDialog(null, "Retiro realizado de cuenta corriente con éxito.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró la cuenta corriente del cliente.");
        }

        private static void consignarEnCuentaAhorros() {
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a consignar:"));
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaAhorros) {
                    producto.depositar(cantidad);
                    JOptionPane.showMessageDialog(null, "Consignación realizada en cuenta de ahorros con éxito.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró la cuenta de ahorros del cliente.");
        }

        private static void retirarDeCuentaAhorros() {
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
            for (ProductoFinanciero producto : productos) {
                if (producto instanceof CuentaAhorros) {
                    producto.retirar(cantidad);
                    JOptionPane.showMessageDialog(null, "Retiro realizado de cuenta de ahorros con éxito.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró la cuenta de ahorros del cliente.");
        }
    }

