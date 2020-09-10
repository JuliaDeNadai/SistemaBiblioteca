/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author leoco
 */
public class Conexion {
     public static Connection connect(){
        Connection c = null;
        try{
            Class.forName("org.hsqldb.jdbcDriver");
            c = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\leoco\\Desktop\\base\\test;hsqldb.lock_file=false", "SA", "");
            System.out.println("Conexão...");
        }catch(Exception ex){
             System.out.println("Error..."+ex);
        }
        return c;
    }
}
