package base;


import bdmysqljava.BaseDatosCUp;
import bdmysqljava.Conexion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomeMeli;
import pages.PageBusqueda;
import pages.PageProduct;

public class BaseTest {
    protected WebDriver driver;
    protected HomeMeli homeMeli;
    protected PageBusqueda MLpageBusq;
    protected PageProduct MLpageProd;
    protected String producto;
    protected BaseDatosCUp bdup;
    protected Conexion c;

    public void setupClass() {
        String baseDatos = "mercadoli";
        producto = "camisones";

        WebDriver driver = new FirefoxDriver();

        homeMeli = new HomeMeli(driver);
        homeMeli.buscar("https://www.mercadolibre.com.ar/");
//        bdup = new BaseDatosCUp();
//        c = new Conexion();
//        bdup.crearBD(baseDatos, c);
//        bdup.crearTabla(baseDatos, producto, c);
        MLpageBusq = new PageBusqueda(driver);
        MLpageProd = new PageProduct(driver, baseDatos, producto);
        driver.manage().window().maximize();
    }


    public void tearDown() {
        driver.close();
        driver.quit();

    }


}