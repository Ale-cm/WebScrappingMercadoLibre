package com.org.PruebaWebScrapp.mercadoLibre;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * PageProduct representa la pagina donde se muestran los productos
 * 
 * @author Alejandro
 *
 */
public class PageProduct {

	private By precioXP = By.xpath("//main//div//div//span//meta/following-sibling::span[2]/span[2]");
	private By nombreXP = By.xpath("//div//h1");
	private String nombrePrueba;
	private String precioPrueba;
	private Map<Integer, Producto> listaDePrecios;
	private ArrayList<String> linksDeProductos;
	private WebDriver driver;

	/**
	 * @param driver
	 */
	public PageProduct(WebDriver driver) {
		super();
		this.driver = driver;
	}

	/**
	 * guardarDatos recibe una lista de url las recorre y luego obtiene el nombre y precio.
	 *  En un map(integer, producto) guarda la posicion(integer) y su nombre y precio (objeto Producto)
	 * 
	 * @param linksDeProductos Lista de url de todos los productos
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	public void guardarDatos(ArrayList<String> linksDeProductos) throws InterruptedException, MalformedURLException {
		listaDePrecios = new HashMap<Integer, Producto>();
		this.linksDeProductos = linksDeProductos;
		// DBG: linksDeProductos.size()
		for (int i = 0; i < 10; i++) {
			driver.navigate().to(linksDeProductos.get(i));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nombrePrueba = driver.findElement(nombreXP).getText(); // div//h1
			precioPrueba = driver.findElement(precioXP).getText(); // Double.valueOf(someString)
			listaDePrecios.put(i, new Producto(nombrePrueba, limpiarPrecio(precioPrueba))); 
		}
	}
	/**
	 * 
	 * @param precio. es un string con un caracter "." que debe eliminarse	
	 * @return un double que representa el precio
	 */
	private double limpiarPrecio(String precio) {
		String pre;
		pre = precio.replace(".", " ");
		return Double.parseDouble(pre.replace(" ", ""));
	}
	/**
	 * mostrar recorre el map imprimiendo por consola el codigo(su posición en el array) el nombre del producto y su precio 
	 */
	public void mostrar() {
		// DBG: System.out.println(listaDePrecios.size());
		for (Entry<Integer, Producto> i : listaDePrecios.entrySet()) {
			System.out.println("| Codigo: " + i.getKey() + "| EL nombre es: " + i.getValue().nombre
					+ " | El precio es: " + i.getValue().precio + " |");
		}
	}
/**
 * Producto representa el nombre/marca y el precio del producto 
 * @author Alejandro
 *
 */
	class Producto {
		private String nombre;
		private double precio;

		public Producto(String nombre, double precio) {
			this.nombre = nombre;
			this.precio = precio;
		}

	}

}
