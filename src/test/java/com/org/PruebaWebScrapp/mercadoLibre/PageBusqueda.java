package com.org.PruebaWebScrapp.mercadoLibre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBusqueda {
	private By xPathLinks = By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
	private List<String> linksDeProductos;
	private String urlProducto = null;
	private Iterator<WebElement> it;
	private List<WebElement> linksPrimeraBusqueda;
	WebDriver driver;
	
		public PageBusqueda(WebDriver driver) {
		super();
		this.driver=driver;
	
	}


		public ArrayList<String> obtenerUrls() {
			linksDeProductos = new ArrayList<String>();
			linksPrimeraBusqueda = driver.findElements(xPathLinks);// guardo Los links en un List WebElement
			//DBG: System.out.println(linksPrimeraBusqueda.size());
			it = linksPrimeraBusqueda.iterator();
			while (it.hasNext()) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				urlProducto = it.next().getAttribute("href");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//DBG: System.out.println(urlProducto);
				linksDeProductos.add(urlProducto);
			}
			return (ArrayList<String>) linksDeProductos;
		}

		
}
