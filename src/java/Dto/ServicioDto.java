
package Dto;

public class ServicioDto {
    
    private String concepto;
    private int idH;
    private String denominacion;
    private float importe;

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

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public ServicioDto() {
    }

    public ServicioDto(String concepto, int idH, String denominacion, float importe) {
        this.concepto = concepto;
        this.idH = idH;
        this.denominacion = denominacion;
        this.importe = importe;
    }
    
}
