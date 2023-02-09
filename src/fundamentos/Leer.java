
package fundamentos;

import java.util.Scanner;

public class Leer {
    
    public static String  porTeclado()
    {
        String cadena=null;
        Scanner sc=new Scanner(System.in);
        cadena=sc.nextLine();
        return cadena;
    }
    
}
