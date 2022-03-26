
package Controlador;

import Dto.ServicioDto;
import Modelo.Habitacion;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    
    private Connection C;
    private PreparedStatement PS;
    private Statement S;
    private ResultSet RS;
    
    public void abrirConexion()
    {
        try {
            String url="jdbc:sqlserver://DESKTOP-E8FRIUV\\SQLEXPRESS:1433;databaseName=Hotel";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            C=DriverManager.getConnection(url,"sa","giandjoe");
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Error al conectarse a la BD");
        }
    }
    public void cerrarConexion()
    {
        try {
            C.close();
            System.out.println("Desconectado de la BD");
        } catch (Exception e) {
            System.out.println("No se pudo desconectar de la BD");
        }
    }
    public void agregarHabitacion(Habitacion nuevaHabitacion)
    {
        try {
            abrirConexion();
            PS=C.prepareStatement("INSERT INTO Habitacion (idH, denominacion) VALUES (?,?)");
            
            PS.setInt(1, nuevaHabitacion.getIdH());
            PS.setString(2, nuevaHabitacion.getDenominacion());
            
            PS.execute();
            PS.close();
            cerrarConexion();
        } catch (Exception e) {
        }
    }
    public ArrayList<Habitacion>listadoH()
    {
        ArrayList<Habitacion>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT * FROM Habitacion");
            
            while(RS.next())
            {
                Habitacion H=new Habitacion();
                
                H.setIdH(RS.getInt(1));
                H.setDenominacion(RS.getString(2));
                
                lista.add(H);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
     public void agregarServicio(Servicio nuevoServicio)
    {
        try {
            abrirConexion();
            PS=C.prepareStatement("INSERT INTO Servicio (concepto, idH, importe) VALUES (?,?,?)");
            
            PS.setString(1, nuevoServicio.getConcepto());
            PS.setInt(2, nuevoServicio.getIdH());
            PS.setFloat(3, nuevoServicio.getImporte());
            
            PS.execute();
            PS.close();
            cerrarConexion();
        } catch (Exception e) {
        }
    }
     public ArrayList<ServicioDto>listadoS()
    {
        ArrayList<ServicioDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT s.concepto, s.idH, h.denominacion, s.importe FROM Servicio s INNER JOIN Habitacion H ON s.idH=h.idH");
            
            while(RS.next())
            {
                ServicioDto S=new ServicioDto();
                
                S.setConcepto(RS.getString(1));
                S.setIdH(RS.getInt(2));
                S.setDenominacion(RS.getString(3));
                S.setImporte(RS.getFloat(4));
                
                lista.add(S);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
    
     public ArrayList<ServicioDto>reporte1()
    {
        ArrayList<ServicioDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT s.concepto, s.idH, h.denominacion, s.importe FROM Servicio s INNER JOIN Habitacion H ON s.idH=h.idH WHERE s.importe>500");
            
            while(RS.next())
            {
                ServicioDto S=new ServicioDto();
                
                S.setConcepto(RS.getString(1));
                S.setIdH(RS.getInt(2));
                S.setDenominacion(RS.getString(3));
                S.setImporte(RS.getFloat(4));
                
                lista.add(S);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
     public ArrayList<ServicioDto>reporte2()
    {
        ArrayList<ServicioDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT TOP 1 concepto, MAX(importe) FROM Servicio GROUP BY concepto ORDER BY MAX(importe) DESC");
            
            while(RS.next())
            {
                ServicioDto S=new ServicioDto();
                
                S.setConcepto(RS.getString(1));
                S.setImporte(RS.getFloat(2));
                
                lista.add(S);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
}
