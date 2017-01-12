/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author xoq5f10
 */
public class Connect {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    
    public void ConectarBasedeDatos(){
        try{
            final String Controlador="com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd="jdbc:mysql://10.205.101.58:3306/telcel";
            conexion = DriverManager.getConnection(url_bd,"tiempos","password51");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void DesconectarBasedeDatos(){
        try{
        
        
            if(conexion != null){
                if(sentencia != null){
                    sentencia.close();
                }
                conexion.close();
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public Connection getConnection(){
        return conexion;
    }
    
    public static void main(String[] args) throws SQLException{
        Connection reg;

        Connect con = new Connect();
        con.ConectarBasedeDatos();
        reg=con.getConnection();
        PreparedStatement pst=reg.prepareStatement("SELECT * FROM tpetpa1 WHERE STT = Tlalnepantla");
        con.resultado=pst.executeQuery();
        while(con.resultado.next()){
             System.out.println(con.resultado.getString("STT"));
         }
        con.DesconectarBasedeDatos();
         
        
    }
    
}
