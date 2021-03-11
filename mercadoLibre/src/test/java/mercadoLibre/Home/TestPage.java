package mercadoLibre.Home;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.org.PruebaWebScrapp.mercadoLibre.AppTest;



public class TestPage {

	public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		AppTest  ML =new AppTest();
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get("https://www.mercadolibre.com.ar/");
		
		ML.iniciarDriver(driver);

		ML.MaxPantalla();
		ML.EscribeBusqueda("zapatillas");
		ML.links();
		 ML.recorrer("zapatillas");
		
		Thread.sleep(3333);
		driver.close();
		
		
	}

}
