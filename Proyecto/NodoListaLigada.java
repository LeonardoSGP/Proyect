public class NodoListaLigada {
    private Indice entrada;
    private NodoListaLigada siguiente;

    public NodoListaLigada(Indice entrada) {
        this.entrada = entrada;
        this.siguiente = null;
    }

    public Indice getEntrada() {
        return entrada;
    }

    public NodoListaLigada getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaLigada siguiente) {
        this.siguiente = siguiente;
    }
}
