class NodoIndice {
    Indice dato;
    NodoIndice siguiente;

    public NodoIndice(Indice dato) {
        this.dato = dato;
    }
}

class ListaEnlazada {
    private NodoIndice cabeza;

    public void insertar(Indice dato) {
        NodoIndice nuevo = new NodoIndice(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoIndice actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public Indice buscar(String cvgeo) {
        NodoIndice actual = cabeza;
        while (actual != null) {
            if (actual.dato.getCVGEO().equals(cvgeo)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
