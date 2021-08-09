package helpers;

import java.awt.HeadlessException;

import org.openqa.selenium.WebDriver;

public class Helpers {
	
	public void espera_S(int tiempo) {
		tiempo*=1000; 
		try {
			Thread.sleep(tiempo);			
		}
		catch (InterruptedException e )
		{
			e.printStackTrace();
			}
		}
	public String detectorOS(){ 	// Advertencia:  verificar el nombre de la carpeta donde estan los drivers
		if(System.getProperty("os.name").equals("Windows 10")) {
			// System.out.println("10"); 
			return  "drivers/chromedriver.exe";
			 
		 }else { // En caso de que sea linux
			// System.out.println("10"); 
			 return  "drivers/chromedriver"; 
		
		 }
		
	}

	public void MaxPantalla(WebDriver driver) throws HeadlessException {
		driver.manage().window().maximize();
	}

	}


