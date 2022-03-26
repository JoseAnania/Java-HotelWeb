
package Servlets;

import Controlador.Conexion;
import Modelo.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletAltaHabitacion", urlPatterns = {"/ServletAltaHabitacion"})
public class ServletAltaHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaHabitacion.jsp");
        rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idH=request.getParameter("idH");
        String denominacion=request.getParameter("denominacion");
        
        Habitacion H=new Habitacion();
        H.setIdH(Integer.parseInt(idH));
        H.setDenominacion(denominacion);
        Conexion C=new Conexion();
        C.agregarHabitacion(H);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hotel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"index.html\">Volver</a></li>");
            out.println("<h1>Se cargo la Habitación exitosamente</h1>");
            out.println("</body>");
            out.println("</html>");
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
