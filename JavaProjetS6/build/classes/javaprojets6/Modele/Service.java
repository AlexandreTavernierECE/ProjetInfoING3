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
public class Service {
    private int code;
    private String nom;
    private String batiment;
    private String directeur;
    
    Service(){
        code = 0;
        nom = "";
        batiment = "";
        directeur = "";
    }
    Service(int _code, String _nom, String _batiment, String _directeur){
        code = _code;
        nom = _nom;
        batiment = _batiment;
        directeur = _directeur;
    }
    
    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getBatiment() {
        return batiment;
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }
    
    
}
