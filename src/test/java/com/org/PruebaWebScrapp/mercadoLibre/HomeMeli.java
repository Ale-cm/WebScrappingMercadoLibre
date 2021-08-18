package com.org.PruebaWebScrapp.mercadoLibre;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

import org.openqa.selenium.WebDriver.Navigation;
public class HomeMeli {
	WebDriver driver;
	Navigation nav;
	private By buscar = By.name("as_word");
	private By btn_buscar = By.xpath("//button//div");

	
	Helpers help = new Helpers();
	
	public void iniciarDriver(WebDriver driver) {
		this.driver = driver;
	}	
	public void buscar(String link) {
		this.driver.navigate().to(link);
	}
	
	public void EscribeBusqueda(String nombre) {
		driver.findElement(buscar).sendKeys(nombre);
		driver.findElement(btn_buscar).click();
	}
	

	

}
