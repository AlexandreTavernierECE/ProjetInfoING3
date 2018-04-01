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
public class Docteur {
    private int numero;
    private String specialite;
    
    Docteur(){
        numero = 0;
        specialite = "";
    }
    
    Docteur(int _numero, String _specialite){
        numero = _numero;
        specialite = _specialite;
    }

    public int getNumero() {
        return numero;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    
}
