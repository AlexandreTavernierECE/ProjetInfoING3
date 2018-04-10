/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alexandre
 */
public class Login extends JFrame{
        int width = 300;
        int height = 265;
        JPanel pan = new JPanel();
        JRadioButton loc = new JRadioButton("Local");
	JRadioButton dis = new JRadioButton("Distance");
        JTextField nomBDD = new JTextField();
	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	JTextField loginECE = new JTextField();
	JPasswordField passwordECE = new JPasswordField();
        JLabel nomBDDlabel =  new JLabel("Nom de la base :       ");
        JLabel loginECElabel =  new JLabel("Login ECE :                  ");
        JLabel passwordECElabel =  new JLabel("Mot de passe ECE :   ");
        
        
	JButton con = new JButton("Connection");
	
	
    public Login(){
        this.setSize(width,height);
	this.setTitle("Page login");
	this.setResizable(false);
	this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        loc.setSelected(true);
        nomBDD.setPreferredSize(new Dimension(125,20));
        login.setPreferredSize(new Dimension(125,20));
        password.setPreferredSize(new Dimension(125,20));
        loginECE.setPreferredSize(new Dimension(125,20));
        passwordECE.setPreferredSize(new Dimension(125,20));
        loginECE.setEnabled(false);
        passwordECE.setEnabled(false);
        
        
        
        pan.add(new JLabel("Connection :    "));
        pan.add(loc);
        pan.add(dis);
        pan.add(getBar(0));
        pan.add(nomBDDlabel);
        pan.add(nomBDD);
        pan.add(getBar(0));
        pan.add(loginECElabel);
        pan.add(loginECE);
        pan.add(getBar(0));
        pan.add(passwordECElabel);
        pan.add(passwordECE);
        pan.add(getBar(0));
        pan.add(new JLabel("Login :                          "));
        pan.add(login);
        pan.add(getBar(0));
        pan.add(new JLabel("Mot de passe :           "));
        pan.add(password);
        pan.add(getBar(5));
        pan.add(con);
        this.setContentPane(pan);
	
        
        loc.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                dis.setSelected(!loc.isSelected());
                nomBDD.setEnabled(loc.isSelected());
                nomBDDlabel.setEnabled(loc.isSelected());
                loginECE.setEnabled(!loc.isSelected());
                loginECElabel.setEnabled(!loc.isSelected());
                passwordECE.setEnabled(!loc.isSelected());
                passwordECElabel.setEnabled(!loc.isSelected());
                }
	});
        
        dis.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                loc.setSelected(!dis.isSelected());
                nomBDD.setEnabled(loc.isSelected());
                nomBDDlabel.setEnabled(loc.isSelected());
                loginECE.setEnabled(!loc.isSelected());
                loginECElabel.setEnabled(!loc.isSelected());
                passwordECE.setEnabled(!loc.isSelected());
                passwordECElabel.setEnabled(!loc.isSelected());
                
                }
	});
        
        pan.repaint();
        repaint();
        try{Thread.sleep(1000/30);}catch(InterruptedException e) {e.printStackTrace();}
        pan.repaint();
        repaint();
        
    }
    public JLabel getBar(int i) {
	JLabel j = new JLabel("");
	j.setPreferredSize(new Dimension(1000, i));
	return j;
    }
}
