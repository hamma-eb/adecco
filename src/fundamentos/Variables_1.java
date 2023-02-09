
package fundamentos;


public class Variables_1 {
    
    int numero; //de instancia
    static String nombre;// de clase
   
  public static void main(String[] args) {
     
      Variables_1 v = new Variables_1();
      v.numero = 5;
      Variables_1.nombre = "Java es fácil";

      float PI = 3.14F;// F ó f
      System.out.println(PI);
      System.out.println(v.numero);
      System.out.println("Nombre: " + Variables_1.nombre);
      /*en función del almacenamiento. 
          Tipos primitivos de variables
          
          NUMERICAS: 
                ENTERAS     byte,short,int,long
                REALES      float,double
          CARACTER          char
          BOOLEANAS         boolean
          
         En java los String son objetos
          (clase String)
   
          
         En función de la posición dentro de la clase
         
          1. Variables de Instancia
          
          2. Variables "De clase"
          3. Variables Locales
       
       */


        
    }//main
  
    
}//clase
