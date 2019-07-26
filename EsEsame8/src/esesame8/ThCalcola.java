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
public class ThCalcola extends Thread {

    DatiCondivisi datiC = new DatiCondivisi();

    public void ThGenera(DatiCondivisi ptrDati) {
        datiC = ptrDati;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Calcola1");
            datiC.chiediPermesso2();
            System.out.println("Calcola2");
            datiC.calcola();
            datiC.daiPermesso3();
        }
    }
}
