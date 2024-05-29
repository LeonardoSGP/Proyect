import java.io.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializadorObjeto {
    public static void serializarObjetos(List<Localidad> localidades, String nombreArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (Localidad localidad : localidades) {
                oos.writeObject(localidad);
            }
        }
    }

    public static List<Localidad> deserializarObjetos(String nombreArchivo) throws IOException, ClassNotFoundException {
        List<Localidad> localidades = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                try {
                    Localidad localidad = (Localidad) ois.readObject();
                    localidades.add(localidad);
                } catch (EOFException e) {
                    break;
                }
            }
        }

        return localidades;
    }
}
