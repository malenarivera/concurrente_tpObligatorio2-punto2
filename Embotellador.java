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
public class Embotellador implements Runnable {
    private Planta p;
    
    public Embotellador(Planta p){
        this.p=p;
    }
    
    public void run() {
        while (true) {
            if (!p.verificarLLenado()) {
                this.prepararBotella();
                p.ponerBotella();
            } else {
                p.notificarEmpaquetador();
                p.esperar();
            }

        }
    }
    
    private void prepararBotella(){
        try{
            System.out.println("Soy el embotellador y preparo una botella");
            Thread.sleep(1000);
       }catch(InterruptedException e){}
        
    }
    
    
    
}
