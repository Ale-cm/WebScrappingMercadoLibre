package com.org.PruebaWebScrapp.mercadoLibre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		ArrayList<String> linksDeProductos = new ArrayList<String>();
		List<WebElement> linksPrimeraBusqueda = driver.findElements(xPathLinks);// guardo Los links en un List WebElement
		// DBG: System.out.println(linksPrimeraBusqueda.size());
		Iterator<WebElement> it = linksPrimeraBusqueda.iterator();
		while (it.hasNext()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String urlProducto = it.next().getAttribute("href");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// DBG: System.out.println(urlProducto);
			linksDeProductos.add(urlProducto);
		}
		return linksDeProductos;
	}

}
