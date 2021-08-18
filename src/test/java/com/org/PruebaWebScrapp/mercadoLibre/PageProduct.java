package com.org.PruebaWebScrapp.mercadoLibre;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageProduct {
	
	private By precioXP = By.xpath("//main//div//div//span//meta/following-sibling::span[2]/span[2]");
	private By nombreXP = By.xpath("//div//h1");
	private String nombrePrueba;
	private String precioPrueba;
	private Map<Integer, Productos> listaDePrecios;
	private ArrayList<String>  linksDeProductos;
	WebDriver driver;
	
	public PageProduct(WebDriver driver) {
		super();
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public void guardarDatos(ArrayList<String>  linksDeProductos) throws InterruptedException, MalformedURLException {
		listaDePrecios = new HashMap<Integer, Productos>();	
		this.linksDeProductos = linksDeProductos;		
		//DBG: linksDeProductos.size()
		for (int i = 0; i < 10; i++) {			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(linksDeProductos.get(i)); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nombrePrueba = driver.findElement(nombreXP).getText(); // div//h1
			precioPrueba = driver.findElement(precioXP).getText() ; //Double.valueOf(someString) 			
			listaDePrecios.put(i, new Productos(nombrePrueba,limpiarPrecio(precioPrueba)));																														//DBG: System.out.println("anda"+i);																														// System.out.println(nombrePrueba + precioPrueba + " nivel " + i);
		}
	}
		private double limpiarPrecio(String precio) {
		String pre;
		pre=precio.replace("."," ");
		return Double.parseDouble(pre.replace(" ", ""));	}
	public void mostrar() {	
		//DBG: System.out.println(listaDePrecios.size());
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
