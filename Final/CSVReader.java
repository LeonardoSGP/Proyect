import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CSVReader {
    public static ArrayList<Localidad> leerCSV(String archivoCSV) {
        ArrayList<Localidad> localidades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 12) {
                    Localidad localidad = new Localidad(
                        datos[0], datos[1], datos[2], datos[3],
                        Integer.parseInt(datos[4]), Double.parseDouble(datos[5]), datos[6],
                        Boolean.parseBoolean(datos[7]), Boolean.parseBoolean(datos[8]),
                        Boolean.parseBoolean(datos[9]), Boolean.parseBoolean(datos[10]),
                        Boolean.parseBoolean(datos[11])
                    );
                    localidades.add(localidad);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localidades;
    }

    public static void escribirObjetos(ArrayList<Localidad> localidades, String archivoObjetos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoObjetos))) {
            for (Localidad localidad : localidades) {
                oos.writeObject(localidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


