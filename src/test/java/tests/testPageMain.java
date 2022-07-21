package tests;

import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;
import helpers.Helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomeMeli;
import pages.PageBusqueda;
import pages.PageProduct;
/**
 * TestPage Clase principal 
 * @author Miguel A. Cabrera
 *
 */
public class TestPage {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver;
		Helpers help= new Helpers();

		String baseDatos="mercadoli";
		String producto="camisa";

		BaseDatosCUp bdup= new BaseDatosCUp();
		Conexion c = new Conexion();
		driver = new FirefoxDriver();
		bdup.crearBD(baseDatos, c);
		bdup.crearTabla(baseDatos, producto, c);
		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver,baseDatos,producto);

		HomeMeli  MLhome =new HomeMeli(driver);

		help.MaxPantalla(driver);
		MLhome.buscar("https://www.mercadolibre.com.ar/");
		MLhome.EscribeBusqueda(producto);
		
		
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		
		MLpageProd.mostrar();

		driver.close();	
	}
}

 



