package models.SistemaProductosTienda;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<models.SistemaProductosTienda.producto> inventario = new ArrayList<>();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- SISTEMA DE INVENTARIO ---");
            System.out.println("1. Entrada (Registrar/Sumar)");
            System.out.println("2. Salida (Restar Inventario)");
            System.out.println("3. Ver Inventario");
            System.out.println("4. Valor Total");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");
            opcion = leer.nextInt();

            if (opcion == 1 || opcion == 2) {
                System.out.print("Ingrese el código: ");
                String cod = leer.next();

                // Buscamos el producto en la lista
                producto encontrado = null;
                for (producto p : inventario) {
                    if (p.getCodigo().equals(cod)) {
                        encontrado = p;
                        break;
                    }
                }

                if (opcion == 1) { // LÓGICA DE ENTRADA
                    if (encontrado != null) {
                        System.out.print("Cantidad a añadir: ");
                        int cant = leer.nextInt();
                        encontrado.setCantidad(encontrado.getCantidad() + cant);
                    } else {
                        System.out.print("Nombre: "); String nom = leer.next();
                        System.out.print("Precio: "); float pre = leer.nextFloat();
                        System.out.print("Cantidad: "); int cant = leer.nextInt();
                        inventario.add(new producto(cod, nom, pre, cant));
                    }
                }
                else { // LÓGICA DE SALIDA (RESTAR)
                    if (encontrado != null) {
                        System.out.print("¿Cuántos salieron?: ");
                        int resta = leer.nextInt();

                        // VALIDACIÓN: No podemos restar más de lo que hay
                        if (resta <= encontrado.getCantidad()) {
                            encontrado.setCantidad(encontrado.getCantidad() - resta);
                            System.out.println("Inventario actualizado.");
                        } else {
                            System.out.println("Error: No hay suficiente stock (Solo hay " + encontrado.getCantidad() + ")");
                        }
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }

            } else if (opcion == 3) {
                for (   producto p : inventario) System.out.println(p.mostrarProducto());
            } else if (opcion == 4) {
                float total = 0;
                for (producto p : inventario) total += p.calcularMonto();
                System.out.println("Valor total: $" + total);
            }
        }
    }
}