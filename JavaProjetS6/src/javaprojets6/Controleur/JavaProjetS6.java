/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Controleur;

import javaprojets6.Vue.Interface;
import javaprojets6.Vue.Login;

/**
 *
 * @author Alexandre
 */
public class JavaProjetS6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login l = new Login();
        while(!l.done)try{Thread.sleep(1000/30);}catch(InterruptedException e) {e.printStackTrace();}
        Interface i = new Interface();
    }
    
}
