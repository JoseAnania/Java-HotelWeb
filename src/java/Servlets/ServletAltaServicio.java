
package Servlets;

import Controlador.Conexion;
import Modelo.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletAltaServicio", urlPatterns = {"/ServletAltaServicio"})
public class ServletAltaServicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        Conexion C=new Conexion();
        ArrayList lista=C.listadoH();
        request.setAttribute("lista", lista);
            
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
        rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String concepto=request.getParameter("concepto");
        String idH=request.getParameter("cboHabitacion");
        String importe=request.getParameter("importe");
        
        Servicio S=new Servicio();
        
        S.setConcepto(concepto);
        S.setIdH(Integer.parseInt(idH));
        S.setImporte(Float.parseFloat(importe));
        
        Conexion C=new Conexion();
        C.agregarServicio(S);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hotel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"index.html\">Volver</a></li>");
            out.println("<h1>Se cargo el Servicio exitosamente</h1>");
            out.println("</body>");
            out.println("</html>");
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
