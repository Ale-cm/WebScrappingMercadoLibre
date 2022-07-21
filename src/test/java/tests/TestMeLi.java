package tests;

import org.testng.annotations.Test;

public class TestMeLi extends base.BaseTest {

        @Test()
        public void FullFlow()  {

                homeMeli.EscribeBusqueda(producto);

                MLpageProd.guardarDatos(MLpageBusq.obtenerUrls());

                MLpageProd.mostrar();

        }


        }





