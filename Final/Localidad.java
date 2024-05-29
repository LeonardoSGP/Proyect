import java.io.Serializable;

public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    private String CVGEO;
    private String ENT_NOM;
    private String MUN_NOM;
    private String LOC_NOM;
    private int Altitud;
    private double Latitud;
    private String Tipoloc;
    private boolean Autocab;
    private boolean Abastecim;
    private boolean Drenaje;
    private boolean Recbasura;
    private boolean AUTMUN;

    public Localidad(String CVGEO, String ENT_NOM, String MUN_NOM, String LOC_NOM, int Altitud, double Latitud, String Tipoloc, boolean Autocab, boolean Abastecim, boolean Drenaje, boolean Recbasura, boolean AUTMUN) {
        this.CVGEO = CVGEO;
        this.ENT_NOM = ENT_NOM;
        this.MUN_NOM = MUN_NOM;
        this.LOC_NOM = LOC_NOM;
        this.Altitud = Altitud;
        this.Latitud = Latitud;
        this.Tipoloc = Tipoloc;
        this.Autocab = Autocab;
        this.Abastecim = Abastecim;
        this.Drenaje = Drenaje;
        this.Recbasura = Recbasura;
        this.AUTMUN = AUTMUN;
    }

    @Override
    public String toString() {
        return "Localidad [CVGEO=" + CVGEO + ", ENT_NOM=" + ENT_NOM + ", MUN_NOM=" + MUN_NOM + ", LOC_NOM=" + LOC_NOM + ", Altitud=" + Altitud + ", Latitud=" + Latitud + ", Tipoloc=" + Tipoloc + ", Autocab=" + Autocab + ", Abastecim=" + Abastecim + ", Drenaje=" + Drenaje + ", Recbasura=" + Recbasura + ", AUTMUN=" + AUTMUN + "]";
    }
}
