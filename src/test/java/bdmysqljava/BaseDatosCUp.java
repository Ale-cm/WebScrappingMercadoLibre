package bdmysqljava;

import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.testng.log4testng.Logger;

public class BaseDatosCUp {
	
	
	/**
	*Recibe el nombre de la base de datos y el objeto Conexion 
	*crea una base de datos si no existe.
	*
	*
	*
	*/
	public void crearBD(String bd,Conexion c) {
		
		try {
			c.ConectarBasedeDatos("");
			c.sentencia.execute("CREATE DATABASE IF NOT EXISTS "+bd);
			System.out.println("La base de datos "+bd+", Fue creada con éxito!");
			c.DesconectarBasedeDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	*Recibe el nombre de la base de datos el nombre de la tabla y el objeto Conexion instanciado
	* 
	*crea una tabla en la base de datos si no existe.
	*
	*
	*
	*/
	public void crearTabla(String bd, String bdt,Conexion c) {
		try {
			c.ConectarBasedeDatos(bd);
			String sql= "CREATE TABLE IF NOT EXISTS "+bdt+" ("
					+"id int NOT NULL,"
					+"nombre varchar(80),"
					+"precio DOUBLE,"
					+"PRIMARY KEY(id)"
					+");";
			c.sentencia.execute(sql);
			 System.out.println("Se creo la base de datos");
			//**DBG: JOptionPane.showMessageDialog(null,"La tabla se ha creado correctamente");
			c.DesconectarBasedeDatos();
			
		} catch (Exception e) {
			System.out.println("crearTabla fallo" + e);
		}
		
	}
	

	/**
	*Recibe el nombre de la base de datos el nombre de la tabla y 
	*el objeto Conexion instanciado
	*un id 
	*un nombre del producto  
	*el precio del producto 
	* 
	* guarda todo en un registro
	*
	*
	*/
	
	public void insertarRegistro(Conexion c,String bd,String bdt, int id, String nombre, double precio ) {
		try {
			c.ConectarBasedeDatos(bd);
		String sql= "INSERT INTO `"+bd+"`.`"+bdt+"` (`id`,`nombre`,`precio`) VALUES ('"+id+"','"+nombre+"','"+precio+"');"; 
			
		//**DBG: System.out.println(sql);
		c.sentencia.execute(sql);
		System.out.println("Se agrego el registro");	
		//**DBG: JOptionPane.showMessageDialog(null, "!los registros estan almacenados con éxito¡");
	
			c.DesconectarBasedeDatos();
		} catch (SQLException e) {
		System.out.println("insertarRegistro Fallo : " + e);
		}
	}
	
}
