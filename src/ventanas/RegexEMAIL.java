/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.regex.Pattern;

/**
 *
 * @author AL
 */
public class RegexEMAIL {
    public static void main(String[] args) {
        
       /* 
[^@]+ cualquier caracter que no sea @ una o más veces seguido de
@ una @ seguido de
[^@]+ cualquier caracter que no sea @ una o más veces seguido de
\. un punto seguido de
[a-zA-Z]{2,} dos o más letras minúsculas o mayúsculas
Un ejemplo en código java de esta expresión regular
*/
String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";

//  devuelve true
System.out.println(Pattern.matches(emailRegexp, "a@b.com"));
System.out.println(Pattern.matches(emailRegexp, "+++@+++.com"));

// devuelve faslse
System.out.println(Pattern.matches(emailRegexp, "@b.com")); // Falta el nombre
System.out.println(Pattern.matches(emailRegexp, "a@b.c")); // El dominio final debe tener al menos dos letras
        
    }
    
}
