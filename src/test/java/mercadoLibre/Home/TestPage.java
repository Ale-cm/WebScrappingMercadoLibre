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

 




//public static final String USERNAME = "alejandrocabrera4";
//public static final String AUTOMATE_KEY = "SJCZYksk2xL82fkgHzZq";
//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

//public static final String URL ="http://192.168.0.127:4545/wd/hub"; 
/*	DesiredCapabilities caps = new DesiredCapabilities();

caps.setCapability("os", "Windows");
caps.setCapability("os_version", "10");
caps.setCapability("browser", "Chrome");
caps.setCapability("browser_version", "80");
caps.setCapability("name", "alejandrocabrera4's First Test");*/
//1	caps.setBrowserName(BrowserType.FIREFOX); 
//		driver = new RemoteWebDriver(new URL(URL),caps);




//	driver.quit();