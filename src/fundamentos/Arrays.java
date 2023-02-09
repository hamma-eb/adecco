/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos;

/**
 *
 * @author tarde
 */
public class Arrays {
    public static void main(String[] args) {
        int numeros [] = new int[10];
        char[]letras;
        letras = new char[4];
        letras[0] = 'h';
        letras[1] = 'o';
        letras[2] = 'i';
        letras[3] = '1';
        
        for (int i = 0; i < letras.length; i++) {
            System.out.println(letras[i]);
        }
        
        String paises[] = {"holanda","bekgica","luxemburgo"};
        
        try {
            String cadena = null;
            int longitud = cadena.length();
            System.out.println(paises[3]);
            System.out.println("pasa por aqui");
        } 
        catch (IndexOutOfBoundsException iobe) {
            System.err.println("te saliste amigo");
            
        }
        catch (NullPointerException npe) {
            System.err.println("te saliste amigo");
            
        }
        catch (Exception ex) {
            System.out.println("Error insprado");
        }
        finally {
            System.out.println("siempre ejecuta");
        }
        
        System.out.println("fin del programa");
        
        
    }
}
