/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Film;

/**
 *
 * @author Usuario
 */
public class FilmDAO implements Need<Film> {

    @Override
    public void crear(Film o) throws Exception {
        Connection cn = null;
        try {
            cn = Conexion.getConnection();
            String query = "insert into film(title,description,release_year,language_id) values (?,?,?,1)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, o.getTitulo());
            pstm.setString(2, o.getDescripcion());
            pstm.setInt(3, o.getAnio());
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

    @Override
    public Boolean verificar(Film o) throws Exception {
        Connection cn = null;
        Boolean val = false;
        try {
            cn = Conexion.getConnection();
            String query = "select * from film where title=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, o.getTitulo());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                val = true;
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }

        return val;
    }

    @Override
    public List<Film> listar() throws Exception {
        Connection cn = null;
        List<Film> lista = new ArrayList<Film>();

        try {
            cn = Conexion.getConnection();
            String query = "Select film_id,title,description,release_year from film order by 1";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Film o = new Film();
                o.setId(rs.getInt("film_id"));
                o.setDescripcion(rs.getString("description"));
                o.setTitulo(rs.getString("title"));
                o.setAnio(rs.getInt("release_year"));
                lista.add(o);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return lista;
    }
    
    public Film buscar(String title) throws Exception{
        Connection cn = null;
        Film o = new Film();
        try {
            cn = Conexion.getConnection();
            String query = "Select film_id,title,description,release_year from film where title=? order by 1 ";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, title);
           
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                
                o.setId(rs.getInt("film_id"));
                o.setTitulo(rs.getString("title"));
                o.setDescripcion(rs.getString("description"));
                o.setAnio(rs.getInt("release_year"));
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
        
        return o;
        
    }

}
