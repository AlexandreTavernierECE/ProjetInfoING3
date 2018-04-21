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
public class Malade {
    private int numero;
    private String nom;
    private String prenom;
    private int tel;
    private String adresse;
    private String mutuelle;    
    
    Malade(){
        numero = 0;
        nom = "";
        prenom = "";
        tel = 0;
        adresse = "";
        mutuelle = "";  
    }
    
    Malade(int _numero, String _nom, String _prenom, int _tel, String _adresse, String _mutuelle){
        numero = _numero;
        nom = _nom;
        prenom = _prenom;
        tel = _tel;
        adresse = _adresse;
        mutuelle = _mutuelle;  
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }
    
    
}
