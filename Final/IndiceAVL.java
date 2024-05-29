import java.util.NoSuchElementException;

public class IndiceAVL {
    private class NodoAVL {
        String CVGEO;
        long posicion;
        int altura;
        NodoAVL izquierda, derecha;

        NodoAVL(String CVGEO, long posicion) {
            this.CVGEO = CVGEO;
            this.posicion = posicion;
            this.altura = 1;
        }
    }

    private NodoAVL raiz;

    public void agregar(String CVGEO, long posicion) {
        raiz = agregar(raiz, CVGEO, posicion);
    }

    private NodoAVL agregar(NodoAVL nodo, String CVGEO, long posicion) {
        if (nodo == null) {
            return new NodoAVL(CVGEO, posicion);
        }

        if (CVGEO.compareTo(nodo.CVGEO) < 0) {
            nodo.izquierda = agregar(nodo.izquierda, CVGEO, posicion);
        } else if (CVGEO.compareTo(nodo.CVGEO) > 0) {
            nodo.derecha = agregar(nodo.derecha, CVGEO, posicion);
        } else {
            throw new IllegalArgumentException("Clave duplicada: " + CVGEO);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        return balancear(nodo);
    }

    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    private NodoAVL balancear(NodoAVL nodo) {
        int balance = obtenerBalance(nodo);
        if (balance > 1) {
            if (obtenerBalance(nodo.izquierda) < 0) {
                nodo.izquierda = rotarIzquierda(nodo.izquierda);
            }
            nodo = rotarDerecha(nodo);
        } else if (balance < -1) {
            if (obtenerBalance(nodo.derecha) > 0) {
                nodo.derecha = rotarDerecha(nodo.derecha);
            }
            nodo = rotarIzquierda(nodo);
        }
        return nodo;
    }

    private int obtenerBalance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;
        x.derecha = y;
        y.izquierda = T2;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;
        y.izquierda = x;
        x.derecha = T2;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }

    public long buscar(String CVGEO) {
        NodoAVL nodo = buscar(raiz, CVGEO);
        if (nodo == null) {
            throw new NoSuchElementException("Clave no encontrada: " + CVGEO);
        }
        return nodo.posicion;
    }

    private NodoAVL buscar(NodoAVL nodo, String CVGEO) {
        if (nodo == null) {
            return null;
        }
        if (CVGEO.compareTo(nodo.CVGEO) < 0) {
            return buscar(nodo.izquierda, CVGEO);
        } else if (CVGEO.compareTo(nodo.CVGEO) > 0) {
            return buscar(nodo.derecha, CVGEO);
        } else {
            return nodo;
        }
    }
}
