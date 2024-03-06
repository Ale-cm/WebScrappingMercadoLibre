package tests;

import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomeMeli;
import pages.PageBusqueda;
import pages.PageProduct;
/**
 * TestPage Clase principal 
 * @author Miguel A. Cabrera
 *
 */
public class testPageMain {

	public static void main(String[] args) {
		String baseDatos="mercadoli";
		String producto="camisa";

		BaseDatosCUp bdup= new BaseDatosCUp();
		Conexion c = new Conexion();
		WebDriver driver = new ChromeDriver();
		//bdup.crearBD(baseDatos, c);
		//bdup.crearTabla(baseDatos, producto, c);
		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver,baseDatos,producto);
		HomeMeli  MLhome =new HomeMeli(driver);
		MLhome.buscar("https://www.mercadolibre.com.ar/");
		MLhome.EscribeBusqueda(producto);
		
		
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		
		MLpageProd.mostrar();

		driver.close();	
	}
}

 



