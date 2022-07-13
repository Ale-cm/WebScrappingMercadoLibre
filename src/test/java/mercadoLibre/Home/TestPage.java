package mercadoLibre.Home;

import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;
import com.org.PruebaWebScrapp.mercadoLibre.HomeMeli;
import com.org.PruebaWebScrapp.mercadoLibre.PageBusqueda;
import com.org.PruebaWebScrapp.mercadoLibre.PageProduct;
import helpers.Helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TestPage Clase principal 
 * @author Miguel A. Cabrera
 *
 */
public class TestPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		Helpers help= new Helpers();

		String baseDatos="mercadoli";
		String producto="camisa";

		BaseDatosCUp bdup= new BaseDatosCUp();
		Conexion c = new Conexion();
		driver = new ChromeDriver();
		bdup.crearBD(baseDatos, c);
		bdup.crearTabla(baseDatos, producto, c);
		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver,baseDatos,producto);

		HomeMeli  MLhome =new HomeMeli(driver);

		MLhome.iniciarDriver(driver);
		help.MaxPantalla(driver);
		MLhome.buscar("https://www.mercadolibre.com.ar/");	//TODO	encasular en ap ml
		MLhome.EscribeBusqueda(producto);
		
		
		//**DBG: System.out.println(MLpbusq.obtenerUrls());
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		
		MLpageProd.mostrar();
	 //DBG:help.espera_S(3);
		driver.close();	
	}
}

 



