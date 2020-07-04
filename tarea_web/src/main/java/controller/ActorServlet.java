/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.google.gson.Gson;
import dao.ActorDAO;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Actor;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ActorServlet", urlPatterns = {"/Crear", "/Verificar", "/Buscar"})
public class ActorServlet extends HttpServlet {

    Actor ac;
    ActorDAO dao;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alias = request.getServletPath();
        switch (alias) {
            case "/Crear":
                Crear(request, response);

                break;
            case "/Verificar":
                Verificar(request, response);

                break;
            case "/Buscar":
                Buscar(request, response);

                break;

        }
    }

    private void Crear(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String msj = "";
        boolean val = true;

        try {
            ac = new Actor();
            ac.setNombres(request.getParameter("nombre"));
            ac.setApellidos(request.getParameter("apellido"));
            dao = new ActorDAO();
            val = dao.verificar(ac);
            if (val) {

                msj = "EL ACTOR YA EXISTE";
                request.setAttribute("mensaje1", msj);
            } else {
                try {
                    dao.crear(ac);
                    System.out.println("gaaaa");
                } catch (Exception e) {
                }
                msj = "ACTOR AGREGADO";

                request.setAttribute("mensaje2", msj);
            }

            
        } catch (Exception e) {

            msj = e.getMessage();

        }

        RequestDispatcher rd = request.getRequestDispatcher("actores.jsp");

        rd.forward(request, response);
    }

    private void Verificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String msj = "";

        try {
            ac = new Actor();
            ac.setNombres(request.getParameter("nombre"));
            ac.setApellidos(request.getParameter("apellido"));
            dao = new ActorDAO();
            boolean val = dao.verificar(ac);
            if (val) {

                msj = "EL ACTOR YA EXISTE";
                request.setAttribute("mensaje1", msj);
            } else {

                msj = "ACTOR AGREGADO";
                request.setAttribute("mensaje2", msj);
            }

        } catch (Exception e) {

            msj = e.getMessage();

        }

        RequestDispatcher rd = request.getRequestDispatcher("actores.jsp");

        rd.forward(request, response);

    }
    
    
    private void Buscar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msj = "";
        ac = new Actor();
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        try {
            dao = new ActorDAO();
            ac = dao.buscar(nombre, apellido);
            Gson gs = new Gson();
            msj= gs.toJson(ac);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(msj);
            response.getWriter().flush();
            response.getWriter().close();

        } catch (Exception e) {

            msj = e.getMessage();

        }
    }
    
    

}
