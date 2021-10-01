package mercadoLibre.Home;
import java.awt.AWTException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.org.PruebaWebScrapp.mercadoLibre.HomeMeli;
import com.org.PruebaWebScrapp.mercadoLibre.PageBusqueda;
import com.org.PruebaWebScrapp.mercadoLibre.PageProduct;

import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;
import helpers.Helpers;
/**
 * TestPage Clase principal 
 * @author Miguel A. Cabrera
 *
 */
public class TestPage {

	public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException {
		String baseDatos="mercadoli";
		String producto="zapatillas";
		WebDriver driver;
		BaseDatosCUp bdup= new BaseDatosCUp();
		Conexion c=new Conexion();
		HomeMeli  MLhome =new HomeMeli(); 
		Helpers help= new Helpers();
		System.setProperty("webdriver.chrome.driver", help.detectorOS());
		driver = new ChromeDriver();
		bdup.crearBD(baseDatos, c);
		bdup.crearTabla(baseDatos, producto, c);
		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver,baseDatos,producto);
		MLhome.iniciarDriver(driver);
		help.MaxPantalla(driver);
		MLhome.buscar("https://www.mercadolibre.com.ar/");	//TODO	encasular en ap ml
		MLhome.EscribeBusqueda(producto);
		
		
		//**DBG: System.out.println(MLpbusq.obtenerUrls());
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		
		MLpageProd.mostrar();
		help.espera_S(3);	
		driver.close();	
	}
}

 



