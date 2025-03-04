package pages;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * PageBusqueda representa la pagina donde se encuentran los productos de la
 * busqueda realizada
 * 
 * @author Miguel A. Cabrera
 *
 */
public class PageBusqueda {
	private final WebDriver driver;
	private final By xPathLinks = By.xpath("//div/div[2]/h3/a[starts-with(@href,'https://')]");
	private final By cssSelecLinks = By.cssSelector("a.ui-search-item__group__element.ui-search-link");

///html/body/main/div/div[2]/section/ol/li[1]/div/div/div[2]/h3/a
	/**
	 */
	public PageBusqueda(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	/**
	 * obtenerUrls obtiene webElements, los filtra y luego devuelve una lista con el url de cada producto
	 * @return retorno la lista de url de los productos que aparecen en la pagina
	 */
	public ArrayList<String> obtenerUrls() {
		ArrayList<String> linksDeProductos = new ArrayList<>();
		List<WebElement> linksPrimeraBusqueda = driver.findElements(xPathLinks);// guardo Los links en un List WebElement
		if(linksPrimeraBusqueda.size()==0){
			linksPrimeraBusqueda = driver.findElements(cssSelecLinks);// guardo Los links en un List WebElement
		}
		for (WebElement webElement : linksPrimeraBusqueda) {
			String urlProducto = webElement.getDomAttribute("href");
			System.out.println(urlProducto);
			linksDeProductos.add(urlProducto);
		}

		return linksDeProductos;
	}

}
