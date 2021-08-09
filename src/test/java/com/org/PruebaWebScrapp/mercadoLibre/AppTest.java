package com.org.PruebaWebScrapp.mercadoLibre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Helpers;

import org.openqa.selenium.WebDriver.Navigation;
public class AppTest {
	WebDriver driver;
	Navigation nav;
	private By buscar = By.name("as_word");
	private By xPathLinks = By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
	private By btn_buscar = By.xpath("//button//div");
	private By precioXP = By.xpath("//main//div//div//span//meta/following-sibling::span[2]/span[2]");
	private By nombreXP = By.xpath("//div//h1");
	private List<WebElement> linksPrimeraBusqueda;
	private Iterator<WebElement> it;
	private String nombrePrueba;
	private String precioPrueba;
	private Map<Integer, Productos> listaDePrecios;
	private List<String> linksDeProductos;
	private String urlProducto = null;
	Helpers help = new Helpers();
	/*
	 * private By buscar=By.id("");
	 */

	public void iniciarDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void EscribeBusqueda(String nombre) throws AWTException {
		driver.findElement(buscar).sendKeys(nombre);
		driver.findElement(btn_buscar).click();
	}

	public void guardarDatos() throws InterruptedException, MalformedURLException {
		
		
		listaDePrecios = new HashMap<Integer, Productos>();
		nav = driver.navigate();

		linksDeProductos = new ArrayList<String>();

		linksDeProductos = obtenerUrls();
																														
																																//	help.espera_S(4);
																														
		
		// linksDeProductos.size()
		for (int i = 0; i < 10; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nav.to(linksDeProductos.get(i)); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nombrePrueba = driver.findElement(nombreXP).getText(); // div//h1
			precioPrueba =driver.findElement(precioXP).getText() ; //Double.valueOf(someString) 
			 
			listaDePrecios.put(i, new Productos(nombrePrueba,limpiarPrecio(precioPrueba)));																														// System.out.println("anda"+i);
																																// System.out.println(links12.size());
																															 //System.out.println(" Este es el precio sin modificar: "+Float.parseFloat((String)precioPrueba));
																																// System.out.println(" Este es el precio modificado:
																																// "+limpiarPrecio(precioPrueba));
			
																																// System.out.println(nombrePrueba + precioPrueba + " nivel " + i);
		}
	}

	private ArrayList<String> obtenerUrls() {
		linksDeProductos = new ArrayList<String>();
		linksPrimeraBusqueda = driver.findElements(xPathLinks);// guardo Los links en un List WebElement
		//System.out.println(linksPrimeraBusqueda.size());
		it = linksPrimeraBusqueda.iterator();
		while (it.hasNext()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			urlProducto = it.next().getAttribute("href");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println(urlProducto);
			linksDeProductos.add(urlProducto);
		}
	

		return (ArrayList<String>) linksDeProductos;
	}

	private double limpiarPrecio(String precio) {
		String pre;
		pre=precio.replace("."," ");
		return Double.parseDouble(pre.replace(" ", ""));	}
	
	public void mostrar() {	
		//System.out.println(listaDePrecios.size());
		for (Entry<Integer, Productos> i : listaDePrecios.entrySet()) {
			System.out.println("| Codigo: " +i.getKey()+"| EL nombre es: "+ i.getValue().nombre + " | El precio es: " + i.getValue().precio +" |");
		}
	}


	class Productos {
		private String nombre;
		private double precio;

		public Productos(String nombre, double precio) {
			this.nombre = nombre;
			this.precio = precio;
		}

	}

}
