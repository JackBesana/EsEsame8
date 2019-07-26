/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class DatiCondivisi {

    float[] v = new float[3];
    ArrayList<Float> vTot = new ArrayList<Float>();

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
        for (int i = 0; i < 3; i++) {
            cartaGenerata = rand.nextInt(10) + 1;
            if (cartaGenerata < 8) {
                valoreCarta = cartaGenerata;
            } else {
                valoreCarta = (float) 0.5;
            }
            v[i] = valoreCarta;
        }

    }

    public synchronized void distribuisci() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Il numero della carta è " + v[i]);
        }
    }

    public synchronized void calcola() {
        for (int i = 0; i < 3; i++) {
            totale += v[i];
        }
        System.out.println("il totale è: " + totale);
        vTot.add(totale);
        totale = 0;
    }

    public synchronized void calcolaVincitore() {
        float massimo = 0;
        for (int i = 0; i < vTot.size(); i++) {
            if ((vTot.get(i) > massimo) && (vTot.get(i) <= 7.5)) {
                massimo = vTot.get(i);
            }
        }

        for (int i = 0; i < vTot.size(); i++) {
            if (vTot.get(i) == massimo) {
                System.out.println("Il giocatore " + (i + 1) + " ha vinto");
            } else {
                System.out.println("Il giocatore " + (i + 1) + " ha perso");
            }
        }
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
