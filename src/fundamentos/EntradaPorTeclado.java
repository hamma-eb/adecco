
package fundamentos;


public class EntradaPorTeclado {

    public static void main(String[] args) {

        System.out.println("Introduce un texto:");
        String texto = Leer.porTeclado();
        System.out.println("Introduce un texto");
        System.out.println("El texto introducido es:\n"
                + texto);

    }

}
