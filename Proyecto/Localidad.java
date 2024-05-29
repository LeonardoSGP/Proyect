import java.io.Serializable;

public class Localidad implements Serializable {
    private String CVGEO;
    private String ENT_NOM;
    private String MUN_NOM;
    private String LOC_NOM;
    private double Altitud;
    private double Latitud;
    private String Tipoloc;
    private String Autocab;
    private String Abastecim;
    private String Drenaje;
    private String Recbasura;
    private String AUTMUN;
    private String PROBLEMA;

    public Localidad(String CVGEO, String ENT_NOM, String MUN_NOM, String LOC_NOM, double Altitud, double Latitud, String Tipoloc, String Autocab, String Abastecim, String Drenaje, String Recbasura, String AUTMUN, String PROBLEMA) {
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
        this.PROBLEMA = PROBLEMA;
    }

    public String getCVGEO() {
        return CVGEO;
    }

    public String toString() {
        return "CVGEO: " + CVGEO + ", ENT_NOM: " + ENT_NOM + ", MUN_NOM: " + MUN_NOM + ", LOC_NOM: " + LOC_NOM + ", Altitud: " + Altitud + ", Latitud: " + Latitud + ", Tipoloc: " + Tipoloc + ", Autocab: " + Autocab + ", Abastecim: " + Abastecim + ", Drenaje: " + Drenaje + ", Recbasura: " + Recbasura + ", AUTMUN: " + AUTMUN + ", PROBLEMA: " + PROBLEMA;
    }
}

