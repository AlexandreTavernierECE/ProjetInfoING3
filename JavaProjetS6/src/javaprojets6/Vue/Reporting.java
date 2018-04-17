/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Vue;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprojets6.Controleur.Connexion;
import static javaprojets6.Controleur.Connexion.requetes;

/**
 *
 * @author matpo
 */
public class Reporting extends JFrame {
    
    int width = 500;
    int height = 500;
    
    JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT));     
    JLabel label = new JLabel("Entrer une requete en commande sql :                             ");
    JTextArea field = new JTextArea(6,30);
    JButton buton = new JButton("Executer");
    JLabel label2 = new JLabel();
    JTextArea field2 = new JTextArea(15,30);
    JScrollPane scroll;
            
    Connexion c;
    
    public Reporting() throws SQLException, ClassNotFoundException{
    
    this.setSize(width,height);
    this.setTitle("Reporting");
    c = new Connexion("hopital","root","");
    
    field2.setEditable(false);
    scroll = new JScrollPane(field2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setBackground(Color.white);
    this.setContentPane(pan);
    setUpListeners();
    
    pan.add(label);
    pan.add(field);
    pan.add(buton);
    //pan.add(field2);
    pan.add(scroll);
    pan.getRootPane().revalidate();
    
    }
    
    public void setUpListeners(){
        buton.addActionListener(new ActionListener(){
                @Override
		public void actionPerformed(ActionEvent e) {
                      
                    String input = field.getText();
                    try {
                        requetes = c.remplirChampsRequete(input);
                    } catch (SQLException ex) {
                        Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    for (String element : requetes) {
                        field2.append(element);
                    }
                }
	});
    }
}
