
package fundamentos;


class Animal {
    
    String especie;
    String tipo;
    int   numeroPatas;

    public Animal(String especie, String tipo, int numeroPatas) {
        this.especie = especie;
        this.tipo = tipo;
        this.numeroPatas = numeroPatas;
    }
    public Animal()
    {
        
        
    }

    @Override
    public String toString() {
        return "Animal{" + "especie=" + especie + ", tipo=" + tipo + ", numeroPatas=" + numeroPatas + '}';
    }
    
    
    

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }
    
    
    
    
}




