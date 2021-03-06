package com.org.PruebaWebScrapp.mercadoLibre;
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
	Navigation nav;
	private By buscar = By.name("as_word");
	private By btn_buscar = By.xpath("//button//div");

	
	Helpers help = new Helpers();
	/**
	 * Inicia el driver que recibe.
	 * @param driver.
	 */
	public void iniciarDriver(WebDriver driver) {
		this.driver = driver;
	}	
	/**
	 * Buscar. va hacia la direccion que llega desde link	
	 * @param link. dirección web a la cual se quiere ir en este caso la pagina principal de mercado libre
	 */
	public void buscar(String link) {
		this.driver.navigate().to(link);
	}
	/**
	 * EscribeBusqueda. Escribe la busqueda en el cuadro de busqueda de la pagina mercadolibre
	 *  y da click en el boton buscar.
	 * @param nombre. nombre del producto a buscar
	 */
	public void EscribeBusqueda(String nombre) {
		driver.findElement(buscar).sendKeys(nombre);
		driver.findElement(btn_buscar).click();
	}
	

	

}
