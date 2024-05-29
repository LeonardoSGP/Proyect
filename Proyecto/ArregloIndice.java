import java.util.Arrays;

public class ArregloIndice {
    private Indice[] indice;

    public ArregloIndice(int tamaño) {
        indice = new Indice[tamaño];
    }

    public void agregarEntrada(Indice entrada, int índice) {
        this.indice[índice] = entrada;
    }

    public Indice buscar(String CVGEO) {
        for (Indice entrada : indice) {
            if (entrada != null && entrada.getCVGEO().equals(CVGEO)) {
                return entrada;
            }
        }
        return null;
    }

    public String toString() {
        return Arrays.toString(indice);
    }
}
