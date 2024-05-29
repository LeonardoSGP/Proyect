import java.util.LinkedList;

public class IndiceListaLigada {
    private LinkedList<Nodo> lista;

    public IndiceListaLigada() {
        lista = new LinkedList<>();
    }

    public void agregar(String CVGEO, long posicion) {
        lista.add(new Nodo(CVGEO, posicion));
    }

    public long buscar(String CVGEO) {
        for (Nodo nodo : lista) {
            if (nodo.CVGEO.equals(CVGEO)) {
                return nodo.posicion;
            }
        }
        return -1;
    }

    private class Nodo {
        String CVGEO;
        long posicion;

        Nodo(String CVGEO, long posicion) {
            this.CVGEO = CVGEO;
            this.posicion = posicion;
        }
    }
}
