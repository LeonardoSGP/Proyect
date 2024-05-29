public class Indice {
    private String CVGEO;
    private int posicion;

    public Indice(String CVGEO, int posicion) {
        this.CVGEO = CVGEO;
        this.posicion = posicion;
    }

    public String getCVGEO() {
        return CVGEO;
    }

    public int getPosicion() {
        return posicion;
    }
}