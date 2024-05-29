import java.io.Serializable;

public class Localidad implements Serializable {
    private String cvgeo;
    private String entNom;
    private String munNom;
    private String locNom;
    private int altitud;
    private int latitud;
    private String tipoloc;
    private boolean autocab;
    private boolean abastecim;
    private boolean drenaje;
    private boolean recbasura;
    private boolean autmun;
    public Localidad(String cvgeo, String entNom, String munNom, String locNom, int altitud, int latitud, String tipoloc,
                     boolean autocab, boolean abastecim, boolean drenaje, boolean recbasura, boolean autmun) {
        this.cvgeo = cvgeo;
        this.entNom = entNom;
        this.munNom = munNom;
        this.locNom = locNom;
        this.altitud = altitud;
        this.latitud = latitud;
        this.tipoloc = tipoloc;
        this.autocab = autocab;
        this.abastecim = abastecim;
        this.drenaje = drenaje;
        this.recbasura = recbasura;
        this.autmun = autmun;
    }
    public String getCVGEO() {
        return cvgeo;
    }
    @Override
    public String toString() {
        return "Localidad{" +
                "CVGEO='" + cvgeo + '\'' +
                ", ENT_NOM='" + entNom + '\'' +
                ", MUN_NOM='" + munNom + '\'' +
                ", LOC_NOM='" + locNom + '\'' +
                ", Altitud=" + altitud +
                ", Latitud=" + latitud +
                ", Tipoloc='" + tipoloc + '\'' +
                ", Autocab=" + autocab +
                ", Abastecim=" + abastecim +
                ", Drenaje=" + drenaje +
                ", Recbasura=" + recbasura +
                ", AUTMUN=" + autmun +
                '}';
    }
}

