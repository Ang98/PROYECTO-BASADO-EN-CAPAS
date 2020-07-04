/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.FilmDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "PeliculaServlet", urlPatterns = {"/CrearPelicula", "/VerificarPelicula", "/BuscarPelicula"})
public class PeliculaServlet extends HttpServlet {

    Film peli;
    FilmDAO dao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alias = request.getServletPath();
        switch (alias) {
            case "/CrearPelicula":
                Crear(request, response);

                break;
            case "/VerificarPelicula":
                Verificar(request, response);

                break;
            case "/BuscarPelicula":
                Buscar(request, response);

                break;

        }
    }

    private void Crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msj = "";
        boolean val = true;

        try {
            peli = new Film();
            peli.setTitulo(request.getParameter("titulo"));
            peli.setAnio(Integer.parseInt(request.getParameter("anio")));
            peli.setDescripcion(request.getParameter("descripcion"));

            dao = new FilmDAO();
            val = dao.verificar(peli);
            if (val) {

                msj = "LA PELICULA YA EXISTE";
                request.setAttribute("mensaje1", msj);
            } else {
                try {
                    dao.crear(peli);

                } catch (Exception e) {
                }
                msj = "PELICULA AGREGADA";

                request.setAttribute("mensaje2", msj);
            }

        } catch (Exception e) {

            msj = e.getMessage();

        }
        Gson gs = new Gson();
        msj = gs.toJson(msj);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msj);
        response.getWriter().flush();
        response.getWriter().close();
    }

    private void Verificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msj = "";

        try {
            peli = new Film();
            peli.setTitulo(request.getParameter("titulo"));
            peli.setAnio(Integer.parseInt(request.getParameter("anio")));
            peli.setDescripcion(request.getParameter("descripcion"));
            dao = new FilmDAO();
            boolean val = dao.verificar(peli);
            if (val) {

                msj = "SI";

            } else {

                msj = "NO";

            }

            Gson gs = new Gson();
            msj = gs.toJson(msj);

        } catch (Exception e) {

            msj = "ERROR";

        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msj);
        response.getWriter().flush();
        response.getWriter().close();

    }

    private void Buscar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msj = "";
        peli = new Film();
        String titulo = request.getParameter("titulo");

        try {
            dao = new FilmDAO();
            peli = dao.buscar(titulo);
            Gson gs = new Gson();
            msj = gs.toJson(peli);

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
