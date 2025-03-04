package helpers;



/**
 * Helpers es una clase para metodos comunes a todas las clases o de ayuda.
 * @author Alejandro
 *
 */
public class Helpers {
	/**
	 * espera_S es un tread.sleep para trabajar con segundos en vez de milisegundos
	 * @param tiempo recibe un valor que representa los segundos
	 */
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
	/**
	 * detectorOS dectecta el sistema operativo 
	 * @return devuelve el path del driver correcto 
	 */
	public String detectorOS(){ 	// Advertencia:  verificar el nombre de la carpeta donde estan los drivers
		if(System.getProperty("os.name").equals("Windows 10")) {
			// System.out.println("10"); 
			return  "drivers/chromedriver.exe";
			 
		 }else { // En caso de que sea linux
			// System.out.println("10"); 
			 return  "drivers/chromedriver"; 
		 }	
	}
/**
 * MaxPantalla maximiza la pantalla 
 * @param driver
 * @throws HeadlessException
 */
	// public void MaxPantalla(WebDriver driver) throws HeadlessException {
	//driver.manage().window().maximize();
	//}

	
}


