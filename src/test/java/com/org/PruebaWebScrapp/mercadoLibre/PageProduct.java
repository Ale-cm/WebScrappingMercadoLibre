package com.org.PruebaWebScrapp.mercadoLibre;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;

/**
 * PageProduct representa la pagina donde se muestran los productos
 * 
 *@author Miguel A. Cabrera
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
	private JSONArray json;
	Conexion c=new Conexion();
	BaseDatosCUp bdup= new BaseDatosCUp();
	private String bd="";
	private String bdt="";
	/**
	 * @param driver
	 */
	public PageProduct(WebDriver driver,String bd,String bdt) {
		super();
		this.driver = driver;
		this.bd=bd;
		this.bdt=bdt;
	
	}

	/**
	 * guardarDatos recibe una lista de url las recorre y luego obtiene el nombre y
	 * precio. En un map(integer, producto) guarda la posicion(integer) y su nombre
	 * y precio (objeto Producto)
	 * 
	 * @param linksDeProductos Lista de url de todos los productos
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	public void guardarDatos(ArrayList<String> linksDeProductos) throws InterruptedException, MalformedURLException {
		listaDePrecios = new HashMap<Integer, Producto>();
		this.linksDeProductos = linksDeProductos;
		// DBG: linksDeProductos.size()
		json = new JSONArray();

		for (int i = 0; i < 5; i++) {
			driver.navigate().to(linksDeProductos.get(i));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nombrePrueba = driver.findElement(nombreXP).getText(); // div//h1
			precioPrueba = driver.findElement(precioXP).getText(); // Double.valueOf(someString)
			bdup.insertarRegistro(c,bd,bdt,i,nombrePrueba, limpiarPrecio(precioPrueba));
			listaDePrecios.put(i, new Producto(nombrePrueba, limpiarPrecio(precioPrueba)));
			json.add(new Producto(nombrePrueba, new Double(limpiarPrecio(precioPrueba))));
			
			
		}
		guardarJson(json);
	}

	/**
	 * guarda el JSONArray en un archivo.json
	 * 
	 * @param jsonA JSONArray que guardo en un archivo.json
	 */
	public void guardarJson(JSONArray jsonA) {
		// DBG: System.out.println(json);
		try {
			FileWriter file = new FileWriter("archivoJson/prueba.json");
			file.write(jsonA.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("parece que no." + e);
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
	 * mostrar recorre el map imprimiendo por consola el codigo(su posición en el
	 * array) el nombre del producto y su precio
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
	 * 
	 * @author Alejandro
	 *
	 */
	class Producto implements JSONAware {
		private String nombre;
		private double precio;

		public Producto(String nombre, double precio) {
			this.nombre = nombre;
			this.precio = precio;
		}

		@Override
		public String toJSONString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("nombre");
			sb.append(":");
			sb.append("\"" + JSONObject.escape(nombre) + "\"");
			sb.append(",");
			sb.append("Precio");
			sb.append(":");
			sb.append(precio);
			sb.append("}");
			return sb.toString();

		}

	}

}
