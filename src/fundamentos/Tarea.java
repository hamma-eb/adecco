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
public class Tarea {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("Mi tarea");
        System.out.println(t);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                t.sleep(1000);
                if(i == 3) {
                    t.interrupt();
                }
            } catch (InterruptedException ie) {
                System.out.println("f");
            }
        }
    }
}
