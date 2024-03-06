package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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

	private final By precioXP = By.xpath("//span[@class='andes-money-amount__fraction']");
	private final By nombreXP = By.xpath("//div//h1");
	private Map<Integer, Producto> listaDePrecios;
	private final WebDriver driver;
	Conexion c=new Conexion();
	//BaseDatosCUp bdup= new BaseDatosCUp();
	private final String bd;
	private final String nameBdT;
	/**
	 */
	public PageProduct(WebDriver driver,String bd,String nameBdT) {
		super();
		this.driver = driver;
		this.bd=bd;
		this.nameBdT=nameBdT;
	
	}

	/**
	 * guardarDatos recibe una lista de url las recorre y luego obtiene el nombre y
	 * precio. En un map(integer, producto) guarda la posicion(integer) y su nombre
	 * y precio (objeto Producto)
	 * 
	 * @param linksDeProductos Lista de url de todos los productos
	 */
	public void guardarDatos(ArrayList<String> linksDeProductos) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		listaDePrecios = new HashMap<>();
		JSONArray json = new JSONArray();
		String nameProduct;
		double priceProduct;
		for (int i = 0; i < 5; i++) {
			driver.navigate().to(linksDeProductos.get(i));
			nameProduct = driver.findElement(nombreXP).getText();
			priceProduct = limpiarPrecio(driver.findElement(precioXP).getText());
	//		bdup.insertarRegistro(c,bd,nameBdT,i, nameProduct, priceProduct);
			listaDePrecios.put(i, new Producto(nameProduct, priceProduct));
			json.add(new Producto(nameProduct, priceProduct));

		}
		guardarJson(json);
	}

	/**
	 * guarda el JSONArray en un archivo.json
	 * 
	 * @param jsonA JSONArray que guardo en un archivo.json
	 */
	public void guardarJson(JSONArray jsonA) {
		try {
			FileWriter file = new FileWriter("archivoJson/"+nameBdT+".json");
			file.write(jsonA.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("Parece que no." + e);
		}

	}

	/**
	 * 
	 * @param precio es un string con un caracter "." que debe eliminarse
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
			return  "{" +
					"\"nombre\"" +
					":" +
					"\"" + JSONObject.escape(nombre) + "\"" +
					"," +
					"\"Precio\"" +
					":" +
					precio +
					"}";

		}

	}

}
