/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esesame8;

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
            DatiCondivisi datiC = new DatiCondivisi();
            
            ThGenera th1 = new ThGenera();
            ThDistribuisci th2 = new ThDistribuisci();
            ThCalcola th3 = new ThCalcola();
            
            th1.start();
            th2.start();
            th3.start();
            
            th1.join();
            th2.join();
            th3.join();
            
            if(datiC.totale==7.5){
                System.out.println("HAI VINTO");
            } else{
                System.out.println("HAI PERSO");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EsEsame8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
