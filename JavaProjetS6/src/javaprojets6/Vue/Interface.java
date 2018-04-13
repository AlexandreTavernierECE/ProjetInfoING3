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
/**
 *
 * @author Alexandre
 */
public class Interface extends JFrame{  
    
    int width = 500;
    int height = 500;
    
    JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    JPanel panRech = new JPanel();
    JPanel panControl = new JPanel();
    JComboBox typeOfInstance;
    DefaultTableModel tableModel;
    String[] typeOfInstanceList = {"Chambre","Docteur","Employe","Hospitalisation","Infirmier","Malade","Service","Soigne"};
    JComboBox typeOfAttribute;
    String chambreList[]  = {"Numéro","Code du service","Surveillant","Nombre de lit"};
    String docteurList[]  = {"Numéro","Specialitée"};
    String employeList[]  = {"Numéro","Nom","Prénom","Telephone","Adresse"};
    String hospitalisationList[]  = {"Numéro du malade","Code du service","Numéro de la chambre","Lit"};
    String infirmierList[]  = {"Numéro du malade","Code du service","Rotation","Salaire"};
    String maladeList[]  = {"Numéro","Nom","Prénom","Salaire","Telephone","Adresse","Mutuelle"};
    String serviceList[]  = {"Code","Nom","Batiment","Directeur"};
    String soigneList[]  = {"Numéro du docteur","Numéro du malade"};
    JScrollPane sp;
        
    JTextField rech = new JTextField();
    
    JButton sup = new JButton("Supprimer");
    JButton ajt = new JButton("Ajouter");
    JButton rep = new JButton("Reporting");
    JButton maj = new JButton("Mise à jour");
	
	
	
    JTable table;
    
    String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[]={"ID","NAME","SALARY"};         
        
    public Interface(){
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
                updateTable();
            }
	});
    }
    
    public JLabel getBar(int i) {
	JLabel j = new JLabel("");
	j.setPreferredSize(new Dimension(1000, i));
	return j;
    }
    
    public void updateTable(){
        String list[] = null;
        switch (typeOfInstance.getSelectedIndex()) {
            case 0:
                list = chambreList;
                break;
            case 1:
                list = docteurList;
                break;
            case 2:
                list = employeList;
                break;
            case 3:
                list = hospitalisationList;
                break;
            case 4:
                list = infirmierList;
                break;
            case 5:
                list = maladeList;
                break;
            case 6:
                list = serviceList;
                break;
            case 7:
                list = soigneList;
                break;
            default:
                break;
        }
        typeOfAttribute.setModel(new DefaultComboBoxModel(list));
        pan.getRootPane().revalidate();
        //JTable jt = new JTable(getTable(list.length,20,"lolilol"),list);
        int numberRow = 30;
        tableModel = new DefaultTableModel(getTable(list.length,numberRow,""),list);
        table.setModel(tableModel);
        pan.getRootPane().revalidate();
        //JScrollPane sp=new JScrollPane(table);
        //
        
    }
    
    public String[][] getTable(int x, int y, String fill){
        
        String strList[][] = new String[y][x];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(fill!=""){
                    strList[j][i] = fill;
                }else{
                    strList[j][i] = "x=" + i + "&y=" + j;
                }
            }
        }
        return strList;
    }
    
    public void setUpPanel(){
           
	pan.removeAll();
        tableModel = new DefaultTableModel(getTable(chambreList.length,30,""),chambreList);
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
    }
}
