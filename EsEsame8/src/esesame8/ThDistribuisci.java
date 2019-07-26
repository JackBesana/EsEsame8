/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

/**
 *
 * @author besan
 */
public class ThDistribuisci extends Thread {

    DatiCondivisi datiC = new DatiCondivisi();
    int nGiocatori;

    public ThDistribuisci(DatiCondivisi ptrDati, int n) {
        datiC = ptrDati;
        nGiocatori = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < nGiocatori; i++) {
            datiC.chiediPermesso1();
            System.out.println("Carta distribuita al giocatore " + (i+1));
            datiC.distribuisci();
            datiC.daiPermesso2();
        }
    }
}
