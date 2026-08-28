import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Taller taller = new Taller();

        int opcion = 0;
        String numero;
        String nombre;
        String placa;
        String descripcion;
        double costo;

        do {
            System.out.println("_________________________________________________________");
            System.out.println("1. Registrar orden");
            System.out.println("2. Consultar órdenes");
            System.out.println("3. Buscar orden");
            System.out.println("4. Modificar orden");
            System.out.println("5. Cancelar orden");
            System.out.println("6. Consultar órdenes por placa");
            System.out.println("7. Reporte de costos");
            System.out.println("8. Orden de mayor costo");
            System.out.println("9. Cantidad de órdenes");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Número de orden: ");
                        numero = scanner.nextLine();

                        System.out.print("Nombre del propietario: ");
                        nombre = scanner.nextLine();

                        System.out.print("Placa: ");
                        placa = scanner.nextLine();

                        System.out.print("Descripción: ");
                        descripcion = scanner.nextLine();

                        System.out.print("Costo estimado: ");
                        costo = Double.parseDouble(scanner.nextLine());

                        taller.registrarorden(numero, nombre, placa, descripcion, costo);
                        System.out.println("Orden registrada correctamente");
                        break;

                    case 2:
                        List<Orden> ordenes = taller.consultarordenes();

                        if (ordenes.isEmpty()) {
                            System.out.println("No hay órdenes registradas");
                        } else {
                            for (Orden orden : ordenes) {
                                System.out.println(orden);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Número de orden: ");
                        numero = scanner.nextLine();

                        Orden ordenEncontrada = taller.buscarorden(numero);
                        System.out.println(ordenEncontrada);
                        break;

                    case 4:
                        System.out.print("Número de orden: ");
                        numero = scanner.nextLine();

                        System.out.print("Nueva descripción: ");
                        descripcion = scanner.nextLine();

                        System.out.print("Nuevo costo: ");
                        costo = Double.parseDouble(scanner.nextLine());

                        taller.modificarorden(numero, descripcion, costo);
                        System.out.println("Orden modificada correctamente");
                        break;

                    case 5:
                        System.out.print("Número de orden: ");
                        numero = scanner.nextLine();

                        taller.cancelarorden(numero);
                        System.out.println("Orden cancelada correctamente");
                        break;

                    case 6:
                        System.out.print("Placa: ");
                        placa = scanner.nextLine();

                        List<Orden> coincidencias = taller.coincidenciasplaca(placa);

                        if (coincidencias.isEmpty()) {
                            System.out.println("No hay órdenes para esa placa");
                        } else {
                            for (Orden orden : coincidencias) {
                                System.out.println(orden);
                            }
                        }
                        break;

                    case 7:
                        System.out.println("Costo total: Q" + taller.totalordenes());
                        System.out.println("Costo promedio: Q" + taller.promedio());
                        break;

                    case 8:
                        Orden ordenMayor = taller.costomasalto();
                        System.out.println(ordenMayor);
                        break;

                    case 9:
                        System.out.println("Cantidad de órdenes: " + taller.cantidadordenesregistradas());
                        break;

                    case 10:
                        System.out.println("¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");

            } catch (Ordenfallida e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Operación terminada");
            }

        } while (opcion != 10);

        scanner.close();
    }
}