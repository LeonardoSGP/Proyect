public class ListaLigada {
    private NodoListaLigada cabeza;

    public void agregar(Indice entrada) {
        NodoListaLigada nuevoNodo = new NodoListaLigada(entrada);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoListaLigada actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public Indice buscar(String CVGEO) {
        NodoListaLigada actual = cabeza;
        while (actual != null) {
            if (actual.getEntrada().getCVGEO().equals(CVGEO)) {
                return actual.getEntrada();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
}
