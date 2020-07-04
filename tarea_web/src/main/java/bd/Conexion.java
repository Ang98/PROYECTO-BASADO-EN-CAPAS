/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Usuario
 */
public class Conexion {

    private static Connection connection = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    //LA CONTRASEÑA INICIAL EN MYSQL XAMPP ES VACIA, DE NO SER ASI INGRESE SU CONTRASEÑA
    private static final String contra = "";
    private static final String url = "jdbc:mysql://localhost:3306/sakila";

    public static Connection getConnection() {
        try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, usuario,contra);
                System.out.println("Conexion LOGRADA a sakila");
            } catch (Exception e) {
                System.out.println("Conexion a sakila NO LOGRADA");
                e.printStackTrace();
            }
            return connection;
        
    }

}
