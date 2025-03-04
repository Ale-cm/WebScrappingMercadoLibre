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

	private final By inputSearchBoxSelector = By.name("as_word");


	public HomeMeli(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * goLink. va hacia la direccion que llega desde link
	 */
	public void goLink(String link) {
		this.driver.navigate().to(link);
	}
	/**
	 * EscribeBusqueda. Escribe la busqueda en el cuadro de busqueda de la pagina mercadolibre
	 *  y da click en el boton buscar.
	 */
	public void EscribeBusqueda(String nombre) {
		driver.findElement(inputSearchBoxSelector).sendKeys(nombre);
		driver.findElement(inputSearchBoxSelector).submit();
	}

}
