/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrenteTeoria;
import java.lang.Thread;
/**
 *
 * @author Diana
 */
public class Empaquetador implements Runnable{
    private Planta p;
    
    
    public Empaquetador (Planta p){
        this.p=p;
    }
    
    public void run() {
        while (true) {
            if (p.cajaLLena()) {
                this.sellarCaja();
                p.notificarEmbotellador();
                p.esperar();
            }
        }
    }

    private void sellarCaja() {
        System.out.println("---------------------------------------------");
        System.out.println("SOY EL EMBOTELLADOR Y ESTOY SELLANDO LA CAJA");
        System.out.println("---------------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
      
        
    


