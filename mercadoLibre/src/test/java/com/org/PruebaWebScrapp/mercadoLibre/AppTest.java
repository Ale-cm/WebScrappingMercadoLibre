package com.org.PruebaWebScrapp.mercadoLibre;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.StaleElementReferenceException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;

/**
 * Unit test for simple App.
 */
public class AppTest 
{		Robot robot;
	 WebDriver driver;
	 Navigation nav;
	 private By buscar=By.name("as_word");
	 private By links1=By.xpath("//ol/li/div/div/a[starts-with(@href,'https://')]");
	 private List<WebElement> links;
	 private Iterator<WebElement> it;
	
/*	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 private By buscar=By.id("");
	 */
	
		public void iniciarDriver(WebDriver driver) throws HeadlessException {
			this.driver=driver;
			
		}	
		
		public void MaxPantalla() throws HeadlessException {
			driver.manage().window().maximize();
	
		}
		
		public void clickCrearCuenta() throws InterruptedException {
		
			driver.findElement(buscar).click();
				
		}
		
		public void EscribeBusqueda(String nombre) throws AWTException  {
			robot= new Robot();
			driver.findElement(buscar).sendKeys(nombre);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		public void links() throws InterruptedException, MalformedURLException {
			nav=driver.navigate();
			links =  driver.findElements(links1);
			String url1=null;
		
		 	this.it= links.iterator();
		 	while (it.hasNext()) {
			url1 = it.next().getAttribute("href");
	
					System.out.println(url1);
					driver.get(url1);			
		 	}}
		
			
		public void recorrer(String busqueda) throws InterruptedException, MalformedURLException, AWTException {
		
			String url1=null;
			URL url;
		 	while (this.it.hasNext()) {
			url1 = it.next().getAttribute("href");
			url=new URL(url1+"/");
			System.out.println(url);
			
			nav.to(url);
			
			driver.get(url1);
			
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	}
	
		 	 
		
		}
	
	
	
	
	
	/**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
