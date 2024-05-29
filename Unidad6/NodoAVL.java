class NodoAVL {
    Indice dato;
    int altura;
    NodoAVL izquierdo, derecho;

    public NodoAVL(Indice dato) {
        this.dato = dato;
        this.altura = 1;
    }
}

class ArbolAVL {
    private NodoAVL raiz;

    private int altura(NodoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;
        y.izquierdo = x;
        x.derecho = T2;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        return y;
    }

    private int getBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierdo) - altura(N.derecho);
    }

    public void insertar(Indice dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoAVL insertarRec(NodoAVL nodo, Indice dato) {
        if (nodo == null)
            return (new NodoAVL(dato));
        if (dato.compareTo(nodo.dato) < 0)
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        else if (dato.compareTo(nodo.dato) > 0)
            nodo.derecho = insertarRec(nodo.derecho, dato);
        else
            return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = getBalance(nodo);

        if (balance > 1 && dato.compareTo(nodo.izquierdo.dato) < 0)
            return rotacionDerecha(nodo);
        if (balance < -1 && dato.compareTo(nodo.derecho.dato) > 0)
            return rotacionIzquierda(nodo);
        if (balance > 1 && dato.compareTo(nodo.izquierdo.dato) > 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && dato.compareTo(nodo.derecho.dato) < 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    public Indice buscar(String cvgeo) {
        return buscarRec(raiz, cvgeo);
    }

    private Indice buscarRec(NodoAVL nodo, String cvgeo) {
        if (nodo == null)
            return null;
        if (cvgeo.equals(nodo.dato.getCVGEO()))
            return nodo.dato;
        if (cvgeo.compareTo(nodo.dato.getCVGEO()) < 0)
            return buscarRec(nodo.izquierdo, cvgeo);
        return buscarRec(nodo.derecho, cvgeo);
    }
}
