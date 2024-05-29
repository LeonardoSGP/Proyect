import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Localidad> leerCSV(String nombreArchivo) throws IOException {
        List<Localidad> localidades = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Localidad localidad = new Localidad(partes[0], partes[1], partes[2], partes[3], Double.parseDouble(partes[4]), Double.parseDouble(partes[5]), partes[6], partes[7], partes[8], partes[9], partes[10], partes[11], partes[12]);
                localidades.add(localidad);
            }
        }

        return localidades;
    }
}
