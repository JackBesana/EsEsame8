/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

import java.io.BufferedReader;
import java.io.IOException;
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

    ArrayList<Float> v = new ArrayList<Float>();
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

    public synchronized void genera() throws IOException {
        Random rand = new Random();
        BufferedReader console = new BufferedReader(new java.io.InputStreamReader(System.in));
        v.clear();
        boolean finito = true;
        while (finito) {
            int i = 0;
            cartaGenerata = rand.nextInt(10) + 1;
            if (cartaGenerata < 8) {
                valoreCarta = cartaGenerata;
            } else {
                valoreCarta = (float) 0.5;
            }
            v.add(valoreCarta);
            i++;
            System.out.println("Vuoi generare ancora una carta? si/no");
            String r = console.readLine();
            if (r.equals("no")) {
                finito = false;
            }
        }
    }

    public synchronized void distribuisci() {
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Il numero della carta è " + v.get(i));
        }
    }

    public synchronized void calcola() {
        for (int i = 0; i < v.size(); i++) {
            totale += v.get(i);
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
