package mercadoLibre.Home;
import java.awt.AWTException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.org.PruebaWebScrapp.mercadoLibre.HomeMeli;
import com.org.PruebaWebScrapp.mercadoLibre.PageBusqueda;
import com.org.PruebaWebScrapp.mercadoLibre.PageProduct;

import helpers.Helpers;
/**
 * TestPage Clase principal
 * @author Alejandro
 *
 */
public class TestPage {

	public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException {
	WebDriver driver;
		HomeMeli  MLhome =new HomeMeli(); 
		Helpers help= new Helpers();
		System.setProperty("webdriver.chrome.driver", help.detectorOS());
		driver = new ChromeDriver();
		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver);
		MLhome.iniciarDriver(driver);
		help.MaxPantalla(driver);
		MLhome.buscar("https://www.mercadolibre.com.ar/");	//TODO	encasular en ap ml
		MLhome.EscribeBusqueda("zapatillas");
		//**DBG: System.out.println(MLpbusq.obtenerUrls());
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		MLpageProd.mostrar();
		help.espera_S(3);	
		driver.close();	
	}
	
}

 



