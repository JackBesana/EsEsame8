/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class DatiCondivisi {

    int cartaGenerata = 0;
    float valoreCarta = 0, totale = 0;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    public DatiCondivisi() {
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(1);
    }

    public synchronized void genera() {
        Random rand = new Random();
        cartaGenerata = rand.nextInt(10) + 1;
        if (cartaGenerata < 8) {
            valoreCarta = cartaGenerata;
        } else {
            valoreCarta = (float) 0.5;
        }
        System.out.println("Sono in dati condivisi");
    }

    public synchronized void distribuisci() {
        System.out.println("Carta distribuita al giocatore 1");
        System.out.println("Il valore della carta è " + cartaGenerata);
    }

    public synchronized void calcola() {
        totale += valoreCarta;
        System.out.println("Sto calcolando");
    }

    public void daiPermesso1() {
        sem1.release();
        
    }

    public void chiediPermesso1() {
        try {
            
            sem1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void daiPermesso2() {
        sem2.release();
    }

    public void chiediPermesso2() {
        try {
            sem2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void daiPermesso3() {
        sem3.release();
    }

    public void chiediPermesso3() {
        try {
            sem3.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
