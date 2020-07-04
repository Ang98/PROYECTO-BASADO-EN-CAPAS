/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.FilmActorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FilmActor;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "FilmActorServlet", urlPatterns = {"/CrearFilmActor"})
public class FilmActorServlet extends HttpServlet {

    FilmActor o = new FilmActor();
    FilmActorDAO dao = new FilmActorDAO();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alias = request.getServletPath();
        switch (alias) {
            case "/CrearFilmActor":
                Crear(request, response);

                break;

        }
    }
    
    private void Crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msj = "";
       
        try {
            o = new FilmActor();
            o.setActor_id(Integer.parseInt(request.getParameter("actor_id")));
            o.setFilm_id(Integer.parseInt(request.getParameter("film_id")));
            
            dao = new FilmActorDAO();
            dao.crear(o);
            msj = "PELICULA AGREGADA CON SUS ACTORES";

           

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


}
