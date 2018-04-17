/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Controleur;

import java.sql.SQLException;
import javaprojets6.Vue.Interface;
import javaprojets6.Vue.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class JavaProjetS6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login log = new Login();
        
        boolean stop = false;
        
        while(stop == false){
            
            try{Thread.sleep(1000/30);}catch(InterruptedException e) {e.printStackTrace();}
            
            if(log.con.getModel().isPressed()){ //si le bouton connexion est appuyé on vérifie les infos
            
            String nomBDD = log.nomBDD.getText();
            String login = log.login.getText();
            char[] pass = log.password.getPassword();
            String password = new String(pass);

            /** Verification des données saisies */
            if((!nomBDD.equals("hopital"))||(!login.equals("root"))||(!password.equals(""))){

                if(!nomBDD.equals("hopital"))
                    JOptionPane.showMessageDialog(null,"Error: La BDD n'existe pas !");
            
                if(!login.equals("root"))
                    JOptionPane.showMessageDialog(null,"Error: Login incorrect !");

                if(!password.equals(""))
                    JOptionPane.showMessageDialog(null,"Error: Password incorrect !");  
                
                log = new Login(); //réaffiche la fênetre connection
                
                }
            else stop = true;
            }
  
            }
        
        Interface i = new Interface(); //appel l'interface principale 
        
        }         
    
}
