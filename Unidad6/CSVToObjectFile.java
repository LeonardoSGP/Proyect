import java.io.*;
import java.util.*;

public class CSVToObjectFile {
    public List<Localidad> cargarLocalidadesDesdeCSV(String csvFile) {
        List<Localidad> localidades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Localidad loc = new Localidad(
                        values[0], // CVGEO
                        values[1], // ENT_NOM
                        values[2], // MUN_NOM
                        values[3], // LOC_NOM
                        Integer.parseInt(values[4]), // Altitud
                        Integer.parseInt(values[5]), // Latitud
                        values[6], // Tipoloc
                        Boolean.parseBoolean(values[7]), // Autocab
                        Boolean.parseBoolean(values[8]), // Abastecim
                        Boolean.parseBoolean(values[9]), // Drenaje
                        Boolean.parseBoolean(values[10]), // Recbasura
                        Boolean.parseBoolean(values[11]) // AUTMUN
                );
                localidades.add(loc);
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
            int medio = (inicio + fin) / 2;
            Indice indice = indices.get(medio);
            int comparacion = indice.getCVGEO().compareTo(cvgeo);

            if (comparacion == 0) {
                return indice.getPosicion();
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
}


