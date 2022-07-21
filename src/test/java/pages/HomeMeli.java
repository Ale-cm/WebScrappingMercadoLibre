package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * HomeMeli representa la pagina principal de Mercado libre en la cual realizaremos la busqueda
 * de un producto 
 * 
 * @author Alejandro
 *
 */
public class HomeMeli {
	WebDriver driver;

	private final By buscar = By.name("as_word");


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
		driver.findElement(buscar).submit();
	}
	

	

}
