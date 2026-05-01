import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Simulador {

    public static void main(String[] args) {

        Cola cola = new Cola();
        Pila historial = new Pila();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n=== SIMULADOR DE COLA ===");
            System.out.println("1. Cargar clientes desde archivo");
            System.out.println("2. Agregar cliente manual");
            System.out.println("3. Atender cliente");
            System.out.println("4. Ver cola");
            System.out.println("5. Ver historial");
            System.out.println("6. Consultar último atendido");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            cola.encolar(linea);
                        }
                        System.out.println("Clientes cargados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error leyendo archivo.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();
                    cola.encolar(nombre);
                    break;

                case 3:
                    String atendido = cola.desencolar();
                    if (atendido != null) {
                        historial.push(atendido);
                        System.out.println("Atendido: " + atendido);
                    } else {
                        System.out.println("No hay clientes en la cola.");
                    }
                    break;

                case 4:
                    cola.mostrarCola();
                    break;

                case 5:
                    historial.mostrarHistorial();
                    break;

                case 6:
                    String ultimo = historial.peek();
                    if (ultimo != null) {
                        System.out.println("Último atendido: " + ultimo);
                    } else {
                        System.out.println("No hay historial.");
                    }
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}