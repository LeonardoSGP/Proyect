import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVToObjectFile manager = new CSVToObjectFile();
        List<Localidad> localidades = manager.cargarLocalidadesDesdeCSV("resloc_20csv14.csv");

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
            scanner.nextLine(); // Consumir el salto de línea

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

        // Crear lista de índices
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
        ListaEnlazada listaIndices = new ListaEnlazada();
        for (int i = 0; i < localidades.size(); i++) {
            listaIndices.insertar(new Indice(localidades.get(i).getCVGEO(), i));
        }

        System.out.println("Ingrese el CVGEO a buscar: ");
        String cvgeo = scanner.nextLine();
        Indice indiceEncontrado = listaIndices.buscar(cvgeo);
        if (indiceEncontrado != null) {
            Localidad localidad = localidades.get(indiceEncontrado.getPosicion());
            System.out.println(localidad);
        } else {
            System.out.println("CVGEO no encontrado.");
        }
    }
    private static void buscarEnArbolAVL(List<Localidad> localidades, Scanner scanner) {
        ArbolAVL arbolIndices = new ArbolAVL();
        for (int i = 0; i < localidades.size(); i++) {
            arbolIndices.insertar(new Indice(localidades.get(i).getCVGEO(), i));
        }
        System.out.println("Ingrese el CVGEO a buscar: ");
        String cvgeo = scanner.nextLine();
        Indice indiceEncontrado = arbolIndices.buscar(cvgeo);
        if (indiceEncontrado != null) {
            Localidad localidad = localidades.get(indiceEncontrado.getPosicion());
            System.out.println(localidad);
        } else {
            System.out.println("CVGEO no encontrado.");
        }
    }
}
