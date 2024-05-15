package com.emergenter.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AvisoController", urlPatterns = {"/AvisoController"})
public class AvisoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AvisoDAO dao = new AvisoDAOimpl();
        Aviso avi = new Aviso();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("aviso", avi);
                request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    avi = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("error al obtener registro" + ex.getMessage());
                }
                
                request.setAttribute("aviso", avi);
                request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                break;
            
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("error al eliminat" + ex.getMessage());
                }
                
                response.sendRedirect("AvisoController");
                break;
            
            case "view":
                List<Aviso> lista = new ArrayList<Aviso>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("error al listat" + ex.getMessage());
                }
                request.setAttribute("avisos", lista);
                request.getRequestDispatcher("avisos.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        String fecha_inscripcion = request.getParameter("fecha_inscripcion");
        
        Aviso avi = new Aviso();
        avi.setId(id);
        avi.setNombres(nombres);
        avi.setApellidos(apellidos);
        avi.setSeminario(seminario);
        avi.setFecha_inscripcion(fecha_inscripcion);
        
        AvisoDAO dao = new AvisoDAOimpl();
        if (id == 0) {
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("error al insertar"+ex.getMessage());
            }
            
        } else {
            try {
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("error al editar"+ex.getMessage());
            }
            
        }
        response.sendRedirect("AvisoController");
    }
    
}
