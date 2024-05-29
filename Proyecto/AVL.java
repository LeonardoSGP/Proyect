public class AVL {
    private NodoAVL raiz;

    public void insertar(Indice entrada) {
        raiz = insertarRecursivo(raiz, entrada);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, Indice entrada) {
        if (nodo == null) {
            return new NodoAVL(entrada);
        }

        if (entrada.getCVGEO().compareTo(nodo.getEntrada().getCVGEO()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), entrada));
        } else if (entrada.getCVGEO().compareTo(nodo.getEntrada().getCVGEO()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), entrada));
        } else {
            return nodo; 
        }

        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && entrada.getCVGEO().compareTo(nodo.getIzquierdo().getEntrada().getCVGEO()) < 0) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && entrada.getCVGEO().compareTo(nodo.getDerecho().getEntrada().getCVGEO()) > 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && entrada.getCVGEO().compareTo(nodo.getIzquierdo().getEntrada().getCVGEO()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && entrada.getCVGEO().compareTo(nodo.getDerecho().getEntrada().getCVGEO()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private int obtenerAltura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }

    private int obtenerBalance(NodoAVL nodo) {
        return nodo == null ? 0 : obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
    }

    private NodoAVL rotacionDerecha(NodoAVL nodo) {
        NodoAVL izquierdo = nodo.getIzquierdo();
        NodoAVL derecho = izquierdo.getDerecho();

        izquierdo.setDerecho(nodo);
        nodo.setIzquierdo(derecho);

        nodo.setAltura(Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())) + 1);
        izquierdo.setAltura(Math.max(obtenerAltura(izquierdo.getIzquierdo()), obtenerAltura(izquierdo.getDerecho())) + 1);

        return izquierdo;
    }

    private NodoAVL rotacionIzquierda(NodoAVL nodo) {
        NodoAVL derecho = nodo.getDerecho();
        NodoAVL izquierdo = derecho.getIzquierdo();

        derecho.setIzquierdo(nodo);
        nodo.setDerecho(izquierdo);

        nodo.setAltura(Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())) + 1);
        derecho.setAltura(Math.max(obtenerAltura(derecho.getIzquierdo()), obtenerAltura(derecho.getDerecho())) + 1);

        return derecho;
    }

    public Indice buscar(String CVGEO) {
        return buscarRecursivo(raiz, CVGEO);
    }

    private Indice buscarRecursivo(NodoAVL nodo, String CVGEO) {
        if (nodo == null) {
            return null;
        }

        if (CVGEO.compareTo(nodo.getEntrada().getCVGEO()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), CVGEO);
        } else if (CVGEO.compareTo(nodo.getEntrada().getCVGEO()) > 0) {
            return buscarRecursivo(nodo.getDerecho(), CVGEO);
        } else {
            return nodo.getEntrada();
        }
    }
}
