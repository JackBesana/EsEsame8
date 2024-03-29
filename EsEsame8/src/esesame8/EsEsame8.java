/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class EsEsame8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            DatiCondivisi datiC = new DatiCondivisi();

            System.out.println("Inserisci il numero dei giocatori");
            int n = input.nextInt();

            ThGenera th1 = new ThGenera(datiC, n);
            ThDistribuisci th2 = new ThDistribuisci(datiC, n);
            ThCalcola th3 = new ThCalcola(datiC, n);

            th1.start();
            th2.start();
            th3.start();

            th1.join();
            th2.join();
            th3.join();

            datiC.calcolaVincitore();

        } catch (InterruptedException ex) {
            Logger.getLogger(EsEsame8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
