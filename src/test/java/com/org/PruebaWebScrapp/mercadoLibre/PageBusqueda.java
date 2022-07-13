package com.org.PruebaWebScrapp.mercadoLibre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PageBusqueda representa la pagina donde se encuentran los productos de la
 * busqueda realizada
 * 
 * @author Miguel A. Cabrera
 *
 */
public class PageBusqueda {
	private final By xPathLinks = By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
	private final WebDriver driver;

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
		// DBG: System.out.println(linksPrimeraBusqueda.size());
		for (WebElement webElement : linksPrimeraBusqueda) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String urlProducto = webElement.getAttribute("href");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// DBG: System.out.println(urlProducto);
			linksDeProductos.add(urlProducto);
		}
		return linksDeProductos;
	}

}
