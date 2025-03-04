import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.HomeMeli;
import pages.PageBusqueda;
import pages.PageProduct;

public class ScrappingWeb {
    public static void main(String[] args) {
		String producto="camisa";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");	// commentar este codigo para ver la ejecucion
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {

		PageBusqueda  MLpageBusq= new PageBusqueda(driver);
		PageProduct MLpageProd=new PageProduct(driver,producto);
		HomeMeli  MLhome =new HomeMeli(driver);
		MLhome.goLink("https://www.mercadolibre.com.ar/");
		MLhome.EscribeBusqueda(producto);
		MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());
		MLpageProd.mostrar();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
    }
}
