package com.tt1.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tt1.test.Servicio;
public class App{
	public static void main(String[] args) {
		// 1. Inicialización de la arquitectura (Instanciamos las clases reales)
        DBStub db = new DBStub();
        Repositorio repo = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repo, mailer);
		
		// 2. Preparar el lector de teclado
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("======================================");
        System.out.println("  BIENVENIDO AL GESTOR DE TO-DOs");
        System.out.println("======================================");

        // 3. Bucle principal del menú
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Añadir un nuevo To-Do");
            System.out.println("2. Agregar correo a la agenda");
            System.out.println("3. Marcar tarea como finalizada");
            System.out.println("4. Consultar tareas pendientes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduce el nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Introduce la fecha límite (formato dd/MM/yyyy) o pulsa ENTER para hacer que caduque en 5 segundos: ");
                    String fechaStr = scanner.nextLine();
                    long fechaLimite = 0;
                    
                    try {
                        if (fechaStr.trim().isEmpty()) {
                            // TRUCO: Si el usuario solo pulsa enter, la tarea caducará muy rápido para probar las alertas
                            fechaLimite = System.currentTimeMillis() + 5000;
                        } else {
                            // Convertimos el texto a milisegundos
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = sdf.parse(fechaStr);
                            fechaLimite = date.getTime();
                        }
                        
                        servicio.anadirTarea(nombre, fechaLimite);
                        System.out.println("=> ¡Tarea añadida con éxito!");
                    } catch (Exception e) {
                        System.out.println("=> ERROR: Formato de fecha incorrecto.");
                    }
                    break;

                case "2":
                    System.out.print("Introduce la dirección de correo: ");
                    String correo = scanner.nextLine();
                    servicio.anadirDireccion(correo);
                    System.out.println("=> ¡Correo añadido a la agenda!");
                    break;

                case "3":
                    // Primero listamos para que el usuario sepa qué IDs existen
                    List<ToDo> pendientesParaCompletar = servicio.listarPendientes();
                    if (pendientesParaCompletar.isEmpty()) {
                        System.out.println("=> No hay tareas pendientes para completar.");
                    } else {
                        System.out.println("Tareas pendientes:");
                        for (ToDo t : pendientesParaCompletar) {
                            System.out.println("ID: " + t.getId() + " - " + t.getNombre());
                        }
                        System.out.print("Introduce el ID de la tarea a completar: ");
                        
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            ToDo tareaSeleccionada = null;
                            
                            // Buscamos la tarea correspondiente a ese ID
                            for (ToDo t : pendientesParaCompletar) {
                                if (t.getId() == id) {
                                    tareaSeleccionada = t;
                                    break;
                                }
                            }
                            
                            if (tareaSeleccionada != null) {
                                servicio.marcarCompletada(tareaSeleccionada);
                                System.out.println("=> ¡Tarea marcada como completada!");
                            } else {
                                System.out.println("=> ERROR: ID no encontrado.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("=> ERROR: Debe introducir un número válido.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("--- TAREAS PENDIENTES ---");
                    List<ToDo> pendientes = servicio.listarPendientes();
                    if (pendientes.isEmpty()) {
                        System.out.println("=> ¡Genial! No tienes tareas pendientes.");
                    } else {
                        for (ToDo t : pendientes) {
                            // Convertimos los milisegundos de vuelta a fecha legible
                            Date d = new Date(t.getFechaLimite());
                            System.out.println("- [ID: " + t.getId() + "] " + t.getNombre() + " (Límite: " + d.toString() + ")");
                        }
                    }
                    break;

                case "5":
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("=> ERROR: Opción no válida. Inténtalo de nuevo.");
            }
        }
        
        scanner.close();
		
		
	}
}