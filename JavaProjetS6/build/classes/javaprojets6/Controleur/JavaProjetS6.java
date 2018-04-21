/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Controleur;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprojets6.Vue.Interface;
import javaprojets6.Vue.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Mathieu
 */
public class JavaProjetS6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Login log = new Login();
        Interface i;
        Connexion connect;
        boolean stop = false;
        
        while(stop == false){
            
            try{Thread.sleep(1000/30);}catch(InterruptedException e) {e.printStackTrace();}
            
            if(log.con.getModel().isPressed()){ //si le bouton connexion est appuyé on vérifie les infos
            
            String nomBDD = log.nomBDD.getText();
            String login = log.login.getText();
            char[] pass = log.password.getPassword();
            String password = new String(pass);

            stop = true; //on sort de la boucle si connexion réussi
            
            try{
                connect = new Connexion(nomBDD,login,password);
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,ex.getMessage()); //message erreur sql
                stop = false; //on reste dans la boucle while
                log = new Login(); //réaffiche la fênetre connection
            }

            }

        }
        i = new Interface(); //appel l'interface principale
    }         
    
}
