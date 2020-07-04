/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import dao.ActorDAO;
import dao.FilmActorDAO;
import dao.FilmDAO;
import java.sql.Connection;
import model.Actor;
import model.Film;
import model.FilmActor;
/**
 *
 * @author Usuario
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FilmActorDAO dao = new FilmActorDAO();
        FilmActor ac = new FilmActor();
        ac.setActor_id(204);
        ac.setFilm_id(1012);
        
        dao.crear(ac);
        
        
        
        System.out.println("error");
        
        /*Connection cn=Conexion.getConnection();
        System.out.println("OK");*/
    }
    
}
