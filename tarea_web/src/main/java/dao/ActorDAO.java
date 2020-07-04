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
import model.Actor;


public class ActorDAO implements Need<Actor> {
    Connection cn = null;
    @Override
    public void crear(Actor o) throws Exception {
        
        try {
            cn = Conexion.getConnection();
            String query = "insert into actor(first_name,last_name) values (?,?)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, o.getNombres());
            pstm.setString(2, o.getApellidos());
            pstm.executeUpdate();
            pstm.close();
        } catch (Exception e) {
            throw e;
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Boolean verificar(Actor o) throws Exception {
        
        Boolean val = false;
        try {
            cn = Conexion.getConnection();
            String query = "select * from actor where first_name=? and last_name=? ";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, o.getNombres());
            pstm.setString(2, o.getApellidos());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                val=true;
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
        
        return val;
    }

    @Override
    public List<Actor> listar() throws Exception {
        
        List<Actor> lista = new ArrayList<Actor>();
        
        try {
            cn = Conexion.getConnection();
            String query = "Select actor_id,first_name,last_name from actor order by 1";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Actor o = new Actor();
                o.setId(rs.getInt("actor_id"));
                o.setNombres(rs.getString("first_name"));
                o.setApellidos(rs.getString("last_name"));
                
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
    
   public Actor buscar(String name,String last) throws Exception{
        Connection cn = null;
        Actor o = new Actor();
        try {
            cn = Conexion.getConnection();
            String query = "select * from actor where first_name=? and last_name=? ";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setString(2, last);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                
                o.setId(rs.getInt("actor_id"));
                o.setNombres(rs.getString("first_name"));
                o.setApellidos(rs.getString("last_name"));
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
