import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVToObjectFile manager = new CSVToObjectFile();
        List<Localidad> localidades = manager.cargarLocalidadesDesdeCSV("resloc_20csv14");

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Buscar con arreglo (Búsqueda binaria)");
            System.out.println("2. Buscar con lista enlazada");
            System.out.println("3. Buscar con árbol AVL");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    buscarEnArreglo(localidades, scanner);
                    break;
                case 2:
                    buscarEnListaEnlazada(localidades, scanner);
                    break;
                case 3:
                    buscarEnArbolAVL(localidades, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void buscarEnArreglo(List<Localidad> localidades, Scanner scanner) {
        System.out.print("Ingrese el CVGEO a buscar: ");
        String cvgeo = scanner.nextLine();

        List<Indice> indices = new ArrayList<>();
        for (int i = 0; i < localidades.size(); i++) {
            indices.add(new Indice(localidades.get(i).getCVGEO(), i));
        }

        indices.sort(Comparator.comparing(Indice::getCVGEO));

        int posicion = CSVToObjectFile.busquedaBinaria(indices, cvgeo);
        if (posicion != -1) {
            Localidad localidad = localidades.get(posicion);
            System.out.println("Localidad encontrada:");
            System.out.println(localidad);
        } else {
            System.out.println("No se encontró ninguna localidad con el CVGEO: " + cvgeo);
        }
    }

    private static void buscarEnListaEnlazada(List<Localidad> localidades, Scanner scanner) {
        // Crear la lista enlazada
        NodoListaEnlazada cabeza = null;
        for (int i = 0; i < localidades.size(); i++) {
            cabeza = insertarAlFinal(cabeza, localidades.get(i), i);
        }

        System.out.print("Ingrese el CVGEO a buscar: ");
        String cvgeo = scanner.nextLine();

        int posicion = buscarEnLista(cabeza, cvgeo, localidades);

        if (posicion != -1) {
            Localidad localidad = localidades.get(posicion);
            System.out.println("Localidad encontrada:");
            System.out.println(localidad);
        } else {
            System.out.println("No se encontró ninguna localidad con el CVGEO: " + cvgeo);
        }
    }

    private static void buscarEnArbolAVL(List<Localidad> localidades, Scanner scanner) {
        AVL arbolAVL = new AVL();

        for (Localidad localidad : localidades) {
            arbolAVL.insertar(new Indice(localidad.getCVGEO(), localidades.indexOf(localidad)));
        }

        System.out.print("Ingrese el CVGEO a buscar: ");
        String cvgeo = scanner.nextLine();

        Indice resultado = arbolAVL.buscar(cvgeo);

        if (resultado != null) {
            Localidad localidad = localidades.get(resultado.getPosicion());
            System.out.println("Localidad encontrada:");
            System.out.println(localidad);
        } else {
            System.out.println("No se encontró ninguna localidad con el CVGEO: " + cvgeo);
        }
    }
    static class NodoListaEnlazada {
        Localidad localidad;
        int posicion;
        NodoListaEnlazada siguiente;
        NodoListaEnlazada(Localidad localidad, int posicion) {
            this.localidad = localidad;
            this.posicion = posicion;
            siguiente = null;
        }
    }

    private static NodoListaEnlazada insertarAlFinal(NodoListaEnlazada cabeza, Localidad localidad, int posicion) {
        NodoListaEnlazada nuevoNodo = new NodoListaEnlazada(localidad, posicion);
        if (cabeza == null) {
            return nuevoNodo;
        }
        NodoListaEnlazada temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevoNodo;
        return cabeza;
    }

    private static int buscarEnLista(NodoListaEnlazada cabeza, String cvgeo, List<Localidad> localidades) {
        int posicion = 0;
        NodoListaEnlazada temp = cabeza;
        while (temp != null) {
            if (temp.localidad.getCVGEO().equals(cvgeo)) {
                return temp.posicion;
            }
            temp = temp.siguiente;
            posicion++;
        }
        return -1;
    }
}
