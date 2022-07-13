package bdmysqljava;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Miguel A. Cabrera
 */
public class Conexion {
 
 public Connection conexion; 
 public Statement sentencia;
 public ResultSet resultado;

public void ConectarBasedeDatos(String bd){
 try {
 final String Controlador = "com.mysql.jdbc.Driver";
 Class.forName( Controlador );
 final String url_bd = "jdbc:mysql://localhost/";
 final String url_bd2 = "jdbc:mysql://localhost:3306/"+bd;
 if(bd.equals("")){ 
 conexion = DriverManager.getConnection(url_bd,"root","");
 }else{
 conexion = DriverManager.getConnection(url_bd2,"root","");
 }
 sentencia = conexion.createStatement();
 } catch (ClassNotFoundException | SQLException ex) {
 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
 }
 }
 public void DesconectarBasedeDatos() {
 try {
 if (conexion != null ) {
 if(sentencia != null) {
 sentencia.close();
 }
 conexion.close();
 }
 }
 catch (SQLException ex) {
 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
 System.exit(1);
 }
 }
 public Connection getConnection(){
 return conexion;
 }
}