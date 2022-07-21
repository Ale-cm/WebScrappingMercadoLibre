package pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import helpers.Helpers;

import org.openqa.selenium.WebDriver.Navigation;
/**
 * HomeMeli representa la pagina principal de Mercado libre en la cual realizaremos la busqueda
 * de un producto 
 * 
 * @author Alejandro
 *
 */
public class HomeMeli {
	WebDriver driver;

	private By buscar = By.name("as_word");
	private By btn_buscar = By.xpath("//button//div");

	
	Helpers help = new Helpers();
	/**
	 * Inicia el driver que recibe.
	 */
	public void iniciarDriver(WebDriver driver) {
		this.driver = driver;
	}

	public HomeMeli(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Buscar. va hacia la direccion que llega desde link
	 */
	public void buscar(String link) {
		this.driver.navigate().to(link);
	}
	/**
	 * EscribeBusqueda. Escribe la busqueda en el cuadro de busqueda de la pagina mercadolibre
	 *  y da click en el boton buscar.
	 */
	public void EscribeBusqueda(String nombre) {
		driver.findElement(buscar).sendKeys(nombre);
		driver.findElement(btn_buscar).click();
	}
	

	

}
