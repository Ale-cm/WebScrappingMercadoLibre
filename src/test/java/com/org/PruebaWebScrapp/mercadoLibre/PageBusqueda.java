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
	private By xPathLinks = By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
	private List<String> linksDeProductos;
	private String urlProducto = null;
	private Iterator<WebElement> it;
	private List<WebElement> linksPrimeraBusqueda;
	private WebDriver driver;

	/**
	 * @param driver
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
		linksDeProductos = new ArrayList<String>();
		linksPrimeraBusqueda = driver.findElements(xPathLinks);// guardo Los links en un List WebElement
		// DBG: System.out.println(linksPrimeraBusqueda.size());
		it = linksPrimeraBusqueda.iterator();
		while (it.hasNext()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			urlProducto = it.next().getAttribute("href");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// DBG: System.out.println(urlProducto);
			linksDeProductos.add(urlProducto);
		}
		return (ArrayList<String>) linksDeProductos;
	}

}
