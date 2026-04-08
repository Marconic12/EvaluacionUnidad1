package models.SistemaGestionEstudiantes;

import models.SistemaGestionEstudiantes.Carrera;
import models.SistemaGestionEstudiantes.Estudiante;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Guardar a todos los estudiantes que registro
        ArrayList<Estudiante> lista = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n========= SISTEMA ACADÉMICO =========");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Mostrar Informe de Rendimiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación por si ponen letra
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número (1, 2 o 3).");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nDATOS DEL ESTUDIANTE");
                    System.out.print("Codigo: ");
                    String cod = sc.next();
                    sc.nextLine();

                    System.out.print("Nombre completo: ");
                    String nom = sc.nextLine();

                    System.out.print("Promedio: ");
                    float prom = sc.nextFloat();

                    System.out.println("\nDATOS DE LA CARRERA");
                    sc.nextLine();
                    System.out.print("Nombre de la Carrera: ");
                    String nomCar = sc.nextLine();

                    System.out.print("Duración en años: ");
                    int dur = sc.nextInt();

                    // 1. Creamos el objeto Carrera
                    Carrera car = new Carrera(nomCar, dur);

                    // 2. Creamos el objeto Estudiante y le enviamos la carrera
                    Estudiante est = new Estudiante(cod, nom, prom, car);

                    // 3. Lo guardamos en nuestra lista
                    lista.add(est);
                    System.out.println("\n Estudiante registrado exitosamente.");
                    break;

                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        int aprobados = 0;
                        int reprobados = 0;

                        System.out.println("\nLISTADO DE ESTUDIANTES:");

                        for (Estudiante e : lista) {
                            System.out.println(e.toString());

                            if (e.aprobar()) {
                                aprobados++;
                            } else {
                                reprobados++;
                            }
                        }

                        System.out.println("\nRESUMEN FINAL:");
                        System.out.println("Aprobados: " + aprobados);
                        System.out.println("Reprobados: " + reprobados);
                    }
                    break;

                case 3:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}