import java.io.*;
import java.util.*;

public class Principal {
    private static final String ARCHIVO_CSV = "resloc_20csv14.csv";
    private static final String ARCHIVO_OBJETOS = "localidades.obj";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cargar el archivo de objetos");
            System.out.println("2. Crear el archivo de objetos");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            ArrayList<Localidad> localidades = null;
            if (opcion == 1) {
                File archivo = new File(ARCHIVO_OBJETOS);
                if (!archivo.exists()) {
                    System.out.println("El archivo de objetos no existe. Por favor, crea el archivo de objetos primero.");
                    continue;
                }
                localidades = cargarArchivoObjetos();
            } else if (opcion == 2) {
                localidades = CSVReader.leerCSV(ARCHIVO_CSV);
                CSVReader.escribirObjetos(localidades, ARCHIVO_OBJETOS);
            } else if (opcion == 3) {
                continuar = false;
                break;
            } else {
                System.out.println("Opción no válida.");
                continue;
            }

            if (localidades != null) {
                // Creación de índices
                IndiceArreglo indiceArreglo = new IndiceArreglo(localidades.size());
                IndiceListaLigada indiceLista = new IndiceListaLigada();
                IndiceAVL indiceAVL = new IndiceAVL();

                for (int i = 0; i < localidades.size(); i++) {
                    String CVGEO = localidades.get(i).toString().split(",")[0];
                    long posicion = i;
                    indiceArreglo.agregar(i, CVGEO, posicion);
                    indiceLista.agregar(CVGEO, posicion);
                    indiceAVL.agregar(CVGEO, posicion);
                }

                System.out.println("Índices creados. ¿Desea buscar por:");
                System.out.println("1. Arreglo");
                System.out.println("2. Lista ligada");
                System.out.println("3. Árbol AVL");
                System.out.println("4. Salir");
                int metodoBusqueda = scanner.nextInt();
                scanner.nextLine(); 

                if (metodoBusqueda == 4) {
                    continuar = false;
                    break;
                }

                System.out.println("Ingrese el CVGEO a buscar:");
                String CVGEO = scanner.nextLine();

                try {
                    long posicion = -1;
                    switch (metodoBusqueda) {
                        case 1:
                            posicion = indiceArreglo.obtenerPosicion(indiceArreglo.buscar(CVGEO));
                            break;
                        case 2:
                            posicion = indiceLista.buscar(CVGEO);
                            break;
                        case 3:
                            posicion = indiceAVL.buscar(CVGEO);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }

                    if (posicion != -1) {
                        System.out.println(localidades.get((int) posicion));
                    } else {
                        System.out.println("Localidad no encontrada.");
                    }
                } catch (Exception e) {
                    System.out.println("Error en la búsqueda: " + e.getMessage());
                }
            }
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }

    private static ArrayList<Localidad> cargarArchivoObjetos() {
        ArrayList<Localidad> localidades = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_OBJETOS))) {
            while (true) {
                try {
                    Localidad localidad = (Localidad) ois.readObject();
                    localidades.add(localidad);
                } catch (EOFException eof) {
                    break; // Se alcanzó el final del archivo
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return localidades;
    }
}


