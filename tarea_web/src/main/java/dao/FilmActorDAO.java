/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.FilmActor;

/**
 *
 * @author Usuario
 */
public class FilmActorDAO {

    public void crear(FilmActor o) throws Exception {
        Connection cn = null;
        try {
            cn = Conexion.getConnection();
            String query = "insert into film_actor(actor_id,film_id) values (?,?)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, o.getActor_id());
            pstm.setInt(2, o.getFilm_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
    }

}
