/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrenteTeoria;

import lineales.estatica.Cola;

/**
 *
 * @author Diana
 */
public class Planta {
     private int cantBotellas, cantLimite;
     private boolean sinTerminar;
     
     public Planta (){
         cantLimite=10;
         cantBotellas=0;
         sinTerminar=true;
    }

    public synchronized void ponerBotella() {
        System.out.println("Agrego botella!!");
        cantBotellas++;
        System.out.println("Cantidad botellas: " + cantBotellas);
    }

    public synchronized boolean verificarLLenado() {
        return (cantBotellas >= cantLimite);
    }

    public synchronized void notificarEmpaquetador() {
        System.out.println("((((((((((((((((((((((((((((((((((((((((((((");
        System.out.println("Se lleno la caja, le aviso al empaquetador");
        System.out.println(")))))))))))))))))))))))))))))))))))))))))))))");
        sinTerminar = false;
        this.notify();
    }

    public synchronized boolean cajaLLena() {
        return (!sinTerminar);
    }

    public synchronized void notificarEmbotellador() {
        System.out.println("???????????????????????????????????????????????????????????????????????");
        System.out.println("Ya selle la caja, le aviso al embotellador que puede empezar otra vez");
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        cantBotellas = 0;
        sinTerminar = true;
        this.notify();
    }

    public synchronized void esperar() {
        try {
            this.wait();
        } catch (InterruptedException e) {
        }
    }

}
