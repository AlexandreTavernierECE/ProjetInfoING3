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
import javax.swing.JOptionPane;
/**
 *
 * @author Alexandre 
 */
public class Interface extends JFrame {  
    
    //attributs
    int width = 500;
    int height = 500;
    
    JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    JPanel panRech = new JPanel();
    JPanel panControl = new JPanel();
    JComboBox typeOfInstance;
    DefaultTableModel tableModel;
    String[] typeOfInstanceList = {"chambre","docteur","employe","hospitalisation","infirmier","malade","service","soigne"};
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
    String instance = "chambre"; //defaut
    String list[] = null;
        
    JTextField rech = new JTextField();
    
    JButton sup = new JButton("Supprimer");
    JButton ajt = new JButton("Ajouter");
    JButton rep = new JButton("Reporting");
    JButton maj = new JButton("Modifier");
    JButton addcase = new JButton("New Row");
    JButton search = new JButton("Rechercher");
	
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
        
        /** paramètres de la fenêtre */
        this.setSize(width,height);
	this.setTitle("Interface");
	this.setResizable(false);
	this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    /** gère le placement de la bar des JLabel */
    public JLabel getBar(int i) {
	JLabel j = new JLabel("");
	j.setPreferredSize(new Dimension(1000, i));
	return j;
    }
    
    /** mis à jour de la table */
    public void updateTable() throws SQLException{
        
        
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
        int numberRow = 40;
        tableModel = new DefaultTableModel(getTable(instance),list);
        table.setModel(tableModel);
        pan.getRootPane().revalidate();
        
    }
    
    /** récupère la table de la base de données */
    public String[][] getTable(String inst) throws SQLException{
        
        String strList[][];
        strList = co.remplirchamp(inst);
        
        return strList;
    }
    
    /** setup le panel */
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
        search.setPreferredSize(new Dimension(112,25));
        
        panRech.setPreferredSize(new Dimension(300,150));
        panControl.setPreferredSize(new Dimension(165,150));

        
        panRech.add(getBar(5));
        panRech.add(new JLabel("Affichage :       "));
        panRech.add(typeOfInstance);
        panRech.add(getBar(10));
        panRech.add(new JLabel("Attribut :           "));
        panRech.add(typeOfAttribute);
        panRech.add(getBar(10));
        panRech.add(new JLabel("Recherche :     "));
        panRech.add(rech);
        panRech.add(search);
        panRech.add(getBar(5));
        pan.add(panRech);
        panControl.add(ajt);
        panControl.add(sup);
        panControl.add(rep);
        //panControl.add(maj);
        panControl.add(addcase);
        pan.add(panControl);
        pan.add(sp);
        pan.getRootPane().revalidate();

    }
    
    /** tous les actionlistener */
    public void setUpListeners(){
        /** Action bouton "supprimer" un element de la BDD*/
        sup.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {

                      int[] list = table.getSelectedRows();
                      for(int i = 0 ; i < list.length ; i++){

                        String attributs[] = new String[table.getColumnCount()];
                        String commande = null;
                        
                        /** récupère la valeur de la case sélectionnée */
                        for(int j=0; j<table.getColumnCount(); j++)
                            attributs[j] = (String) table.getValueAt(table.getSelectedRow(), j);
                        
                        if(instance.equals("chambre"))
                            commande="DELETE FROM chambre"+" WHERE "+table.getColumnName(0)+" = "+attributs[0]+" AND "+table.getColumnName(1)+" = "+attributs[1]+" AND "+table.getColumnName(2)+" = "+attributs[2]+" AND "+table.getColumnName(3)+" = "+attributs[3];
                        
                        if((instance.equals("docteur"))||(instance.equals("employe"))||(instance.equals("hospitalisation"))||(instance.equals("infirmier"))||(instance.equals("malade"))||(instance.equals("service")))
                            commande="DELETE FROM "+ instance +" WHERE "+table.getColumnName(0)+" = "+attributs[0];
                        
                        if(instance.equals("soigne"))
                            commande="DELETE FROM soigne "+table.getColumnName(1)+" = "+attributs[1];
                        
                          try {
                              co.executeUpdate(commande); //exécute la commande sql 
                          } catch (SQLException ex) {
                              Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                          }
                        tableModel.removeRow(table.getSelectedRow());
                      }
                      table.setModel(tableModel);                    
                }
	});
        /** Action bouton "ajouter" un element à la BDD*/
        ajt.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {


                    String attributs[] = new String[table.getColumnCount()];
                    String commande = null;
                     
                    /** récupère la valeur de la case sélectionnée */
                    for(int j=0; j<table.getColumnCount(); j++)
                        attributs[j] = (String) table.getValueAt(table.getSelectedRow(), j);
                    
                    if(instance.equals("docteur"))
                        commande = "INSERT INTO docteur (numero,specialite) VALUES ('"+attributs[0]+"','"+attributs[1]+"')";
                    
                    if(instance.equals("chambre"))
                        commande = "INSERT INTO chambre (code_service,no_chambre,surveillant,nb_lits) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"')";                   
                    
                    if(instance.equals("employe"))
                        commande = "INSERT INTO employe (numero,nom,prenom,adresse,tel) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"','"+attributs[4]+"')";                    
                 
                    if(instance.equals("hospitalisation"))
                        commande = "INSERT INTO hospitalisation (no_malade,code_service,no_chambre,lit) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"')";                    
                    
                    if(instance.equals("infirmier"))
                        commande = "INSERT INTO infirmier (numero,code_service,rotation,salaire) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"')";
                    
                    if(instance.equals("malade"))
                        commande = "INSERT INTO malade (numero,nom,prenom,adresse,tel,mutuelle) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"','"+attributs[4]+"','"+attributs[5]+"')";                    
                    
                    if(instance.equals("service"))
                        commande = "INSERT INTO service (code,nom,batiment,directeur) VALUES ('"+attributs[0]+"','"+attributs[1]+"','"+attributs[2]+"','"+attributs[3]+"')";                    
                    
                    if(instance.equals("soigne"))
                        commande = "INSERT INTO soigne (no_docteur,no_malade) VALUES ('"+attributs[0]+"','"+attributs[1]+"')";                    
                    
                    try {
                        co.executeUpdate(commande); //exécute la commande sql
                    } catch (SQLException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null,ex.getMessage()); //message erreur sql
                    }
                    
                     table.setModel(tableModel);
 
                }
	});
        /** Action bouton "reporting" */
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
        /** Action pour ajouter une ligne dans le tableau */
        addcase.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                    
                    tableModel.addRow(new Object[]{null});
                }
	});

        /** Action afficher la recherche */
        search.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
                    
                    try {
                        recherche();
                    } catch (SQLException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	});        
        
    }
    
    /** récupère et affiche la recherche dans le tableau de l'interface*/
    public void recherche() throws SQLException{
        
        String recherche = rech.getText();
        String inst = typeOfInstance.getSelectedItem().toString();
        String attribute = typeOfAttribute.getSelectedItem().toString();
        
        String[][] tab;
        tab = co.tabrecherche(inst, attribute, recherche);
        
        tableModel = new DefaultTableModel(tab,list);
        table.setModel(tableModel);
        
    }
      
}
