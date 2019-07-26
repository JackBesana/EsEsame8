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

    public ThCalcola(DatiCondivisi ptrDati) {
        datiC = ptrDati;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            datiC.chiediPermesso2();
            datiC.calcola();
            datiC.daiPermesso3();
        }
    }
}
