import java.io.*;
import java.util.*;

public class CSVToObjectFile {
    public List<Localidad> cargarLocalidadesDesdeCSV(String nombreArchivo) {
        List<Localidad> localidades = new ArrayList<>();
        String linea = "";
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                Localidad localidad = new Localidad(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), Double.parseDouble(datos[5]), datos[6], datos[7], datos[8], datos[9], datos[10], datos[11], datos[12]);
                localidades.add(localidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return localidades;
    }

    public static int busquedaBinaria(List<Indice> indices, String cvgeo) {
        int inicio = 0;
        int fin = indices.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            String cvgeoMedio = indices.get(medio).getCVGEO();

            if (cvgeoMedio.equals(cvgeo)) {
                return indices.get(medio).getPosicion();
            }

            if (cvgeoMedio.compareTo(cvgeo) < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }
}
