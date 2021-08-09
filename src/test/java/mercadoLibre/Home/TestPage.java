package mercadoLibre.Home;

import java.awt.AWTException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.org.PruebaWebScrapp.mercadoLibre.AppTest;
import helpers.Helpers;



public class TestPage {

	
	public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException {
	
		AppTest  ML =new AppTest();
		Helpers help= new Helpers();
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", help.detectorOS());
		driver = new ChromeDriver();
		
		ML.iniciarDriver(driver);
		help.MaxPantalla(driver);
		driver.navigate().to("https://www.mercadolibre.com.ar/");	
		ML.EscribeBusqueda("zapatillas");
		ML.guardarDatos();
		ML.mostrar();
		help.espera_S(3);	
		driver.close();	
	}
	
}

 





