## WebScrapping a Mercado Libre 
  - realizo una busqueda 
  - obtengo una lista del url de todos los productos 
  - recorro cada url guardando precio y nombre del producto 
  - muestro por consola los datos.
  - guardo en un archivo .json el precio y nombre del producto
 
## run  
  ` mvn compile && mvn exec:java -Dexec.mainClass="ScrappingWeb" `