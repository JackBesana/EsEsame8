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
public class ThGenera extends Thread {
    
    DatiCondivisi datiC=new DatiCondivisi();
    
    public void ThGenera(DatiCondivisi ptrDati){
        datiC=ptrDati;
    }
    
    @Override
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("Genera1");
            datiC.chiediPermesso3();
            System.out.println("Genera2");
            datiC.genera();
            datiC.daiPermesso1();
        }
    }
}