
package Modelo;

public class Habitacion {
    
    private int idH;
    private String denominacion;

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

    public Habitacion() {
    }

    public Habitacion(int idH, String denominacion) {
        this.idH = idH;
        this.denominacion = denominacion;
    }
    
}
