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

    public void ThGenera(DatiCondivisi ptrDati) {
        datiC = ptrDati;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Distribuisci1");
            datiC.chiediPermesso1();
            System.out.println("Distribuisci2");
            datiC.distribuisci();
            datiC.daiPermesso2();
        }
    }
}
