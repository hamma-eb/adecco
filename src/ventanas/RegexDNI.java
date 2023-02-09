/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.util.regex.Pattern;

/**
 *
 * @author tarde
 */
public class RegexDNI {
    public static void main(String[] args) {
        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
        
        System.out.println(Pattern.matches(dniRegexp,"1234567C"));
        System.out.println(Pattern.matches(dniRegexp,"1234567U"));
        System.out.println(Pattern.matches(dniRegexp,"1234567X"));
    }
}
