/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Controleur;

import java.util.Arrays;
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
       
        Login log = new Login();
        
        
        boolean stop = false;
        
        while(stop == false){
            
            try{Thread.sleep(1000/5);}catch(InterruptedException e) {e.printStackTrace();}
            System.out.println("waiting");
            
            if(log.con.getModel().isPressed()){ //si le bouton connexion est appuyé on vérifie les infos
            
            String nomBDD = log.nomBDD.getText();
            String login = log.login.getText();
            char[] password = log.password.getPassword();
            System.out.println ("nomBDD : " + nomBDD);
            System.out.println("login : "+ login);
            System.out.println("password : "+ Arrays.toString(password));
            
            stop = true;
            }
        } 
            
            //System.out.println("error");
        }
    
    }
