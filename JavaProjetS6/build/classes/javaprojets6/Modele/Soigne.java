/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojets6.Modele;

/**
 *
 * @author Alexandre
 */
public class Soigne {
    private int num_docteur;
    private int num_malade;
    
    Soigne(){
        num_docteur = 0;
        num_malade = 0;
    }

    public Soigne(int _num_docteur, int _num_malade) {
        num_docteur = _num_docteur;
        num_malade = _num_malade;
    }

    public int getNum_docteur() {
        return num_docteur;
    }

    public int getNum_malade() {
        return num_malade;
    }

    public void setNum_docteur(int num_docteur) {
        this.num_docteur = num_docteur;
    }

    public void setNum_malade(int num_malade) {
        this.num_malade = num_malade;
    }
    
    
    
}
