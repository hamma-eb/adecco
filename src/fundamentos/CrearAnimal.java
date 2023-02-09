
package fundamentos;


public class CrearAnimal {
    
 public static void main(String[] args) {
        
       
       
       Animal gato=new Animal("Mamífero","Doméstico",4); 
        
       System.out.println(gato.getEspecie());
       System.out.println(gato.getTipo());
       System.out.println(gato.getNumeroPatas());
       
      Animal perro;
      perro=new Animal();
      
      perro.setEspecie("Mamífero");
      perro.setNumeroPatas(4);
      perro.setTipo("Salvaje");
      
      System.out.println(perro );
      
      
      
       
    }
    
}
