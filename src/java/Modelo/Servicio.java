
package Modelo;

public class Servicio {
    
    private int idS;
    private String concepto;
    private int idH;
    private float importe;

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getIdH() {
        return idH;
    }

    public void setIdH(int idH) {
        this.idH = idH;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Servicio() {
    }

    public Servicio(int idS, String concepto, int idH, float importe) {
        this.idS = idS;
        this.concepto = concepto;
        this.idH = idH;
        this.importe = importe;
    }
    
}
