/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuBasedatos;

import fundamentos.*;

/**
 *
 * @author tarde
 */
public class Coche1 implements java.io.Serializable{
    String matricula;
    String marca;
    String modelo;
    int motor;

    public Coche1(String matricula,String marca, String modelo, int motor) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }
}
