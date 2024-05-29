import java.util.Arrays;

public class IndiceArreglo {
    private String[] indices;
    private long[] posiciones;

    public IndiceArreglo(int size) {
        indices = new String[size];
        posiciones = new long[size];
    }

    public void agregar(int i, String CVGEO, long posicion) {
        indices[i] = CVGEO;
        posiciones[i] = posicion;
    }

    public int buscar(String CVGEO) {
        int index = Arrays.binarySearch(indices, CVGEO);
        return (index >= 0) ? index : -1;
    }

    public long obtenerPosicion(int index) {
        return posiciones[index];
    }
}
