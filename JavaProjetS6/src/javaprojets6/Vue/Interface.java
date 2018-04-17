/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javaprojets6.Controleur.Connexion;
import static javaprojets6.Controleur.Connexion.requetes;
/**
 *
 * @author Alexandre
 */
public class Interface extends JFrame {  
    
    int width = 500;
    int height = 500;
    
    JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    JPanel panRech = new JPanel();
    JPanel panControl = new JPanel();
    JComboBox typeOfInstance;
    DefaultTableModel tableModel;
    String[] typeOfInstanceList = {"Chambre","Docteur","Employe","Hospitalisation","Infirmier","Malade","Service","Soigne"};
    JComboBox typeOfAttribute;
    //String chambreList[]  = {"Numéro","Code du service","Surveillant","Nombre de lit"};
    String chambreList[];
    String docteurList[];
    String employeList[];
    String hospitalisationList[];
    String infirmierList[];
    String maladeList[];
    String serviceList[];
    String soigneList[];
    JScrollPane sp;
        
    JTextField rech = new JTextField();
    
    JButton sup = new JButton("Supprimer");
    JButton ajt = new JButton("Ajouter");
    JButton rep = new JButton("Reporting");
    JButton maj = new JButton("Mise à jour");
	
    JTable table;
    
    Connexion co;
        
    public Interface() throws SQLException, ClassNotFoundException{
        
        /** rempli les champs table dans des tableaux de String */
        this.co = new Connexion("hopital","root","");
        chambreList = co.remplirtable("chambre");
        docteurList = co.remplirtable("docteur");
        employeList = co.remplirtable("employe");
        hospitalisationList = co.remplirtable("hospitalisation");
        infirmierList = co.remplirtable("infirmier");
        maladeList = co.remplirtable("malade");
        serviceList = co.remplirtable("service");
        soigneList = co.remplirtable("soigne");        
        
        this.setSize(width,height);
	this.setTitle("Interface");
	//this.setResizable(false);
	this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setContentPane(pan);
        setUpPanel();
        setUpListeners();
        
        
    typeOfInstance.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                try {
                    updateTable();
                } catch (SQLException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	});
    }
    
    public JLabel getBar(int i) {
	JLabel j = new JLabel("");
	j.setPreferredSize(new Dimension(1000, i));
	return j;
    }
    
    public void updateTable() throws SQLException{
        String list[] = null;
        String instance = "";
        switch (typeOfInstance.getSelectedIndex()) {
            case 0:
                list = chambreList;
                instance = "chambre";
                break;
            case 1:
                list = docteurList;
                instance = "docteur";
                break;
            case 2:
                list = employeList;
                instance = "employe";
                break;
            case 3:
                list = hospitalisationList;
                instance = "hospitalisation";
                break;
            case 4:
                list = infirmierList;
                instance = "infirmier";
                break;
            case 5:
                list = maladeList;
                instance = "malade";
                break;
            case 6:
                list = serviceList;
                instance = "service";
                break;
            case 7:
                list = soigneList;
                instance = "soigne";
                break;
            default:
                break;
        }
        typeOfAttribute.setModel(new DefaultComboBoxModel(list));
        pan.getRootPane().revalidate();
        //JTable jt = new JTable(getTable(list.length,20,"lolilol"),list);
        int numberRow = 40;
        tableModel = new DefaultTableModel(getTable(instance),list);
        table.setModel(tableModel);
        pan.getRootPane().revalidate();
        //JScrollPane sp=new JScrollPane(table);
        //
        
    }
    
    public String[][] getTable(String inst) throws SQLException{
        
        String strList[][];
        strList = co.remplirchamp(inst);
        
        return strList;
    }
    
    public void setUpPanel() throws SQLException{
           
	pan.removeAll();
        tableModel = new DefaultTableModel(getTable("chambre"),chambreList); //par defaut
        table = new JTable();
        table.setModel(tableModel);
        sp=new JScrollPane(table);
        sp.setPreferredSize(new Dimension(width-25,height-200));
        
        
        typeOfInstance = new JComboBox(typeOfInstanceList);
        typeOfInstance.setPreferredSize(new Dimension(200,20));
        
        typeOfAttribute =  new JComboBox(chambreList);
        typeOfAttribute.setPreferredSize(new Dimension(200,20));
         
        rech.setPreferredSize(new Dimension(200,20));
        
        panRech.setPreferredSize(new Dimension(300,135));
        panControl.setPreferredSize(new Dimension(165,135));
        
        
        
        
        
        panRech.add(getBar(5));
        panRech.add(new JLabel("Affichage :       "));
        panRech.add(typeOfInstance);
        panRech.add(getBar(10));
        panRech.add(new JLabel("Attribut :           "));
        panRech.add(typeOfAttribute);
        panRech.add(getBar(10));
        panRech.add(new JLabel("Recherche :     "));
        panRech.add(rech);
        panRech.add(getBar(5));
        pan.add(panRech);
        panControl.add(ajt);
        panControl.add(sup);
        panControl.add(rep);
        panControl.add(maj);
        pan.add(panControl);
        pan.add(sp);
        pan.getRootPane().revalidate();
    }
    
    public void setUpListeners(){
        sup.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                      int[] list = table.getSelectedRows();
                      for(int i = 0 ; i < list.length ; i++){
                          tableModel.removeRow(table.getSelectedRow());
                          System.out.print(list[i] + "   ");
                            //((DefaultTableModel)table.getModel()).removeRow(list[i]);
                           
                      }
                      table.setModel(tableModel);
                }
	});
        ajt.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                     tableModel.addRow(new Object[]{null});
                     table.setModel(tableModel);
                     
                     
                }
	});
        rep.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                    
                    try { 
                        new Reporting();
                    } catch (SQLException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                }
	});
        
    }
      
}
