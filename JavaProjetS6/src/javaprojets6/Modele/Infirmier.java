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
public class Infirmier {
    private int numero;
    private String code_service;
    private String rotation;
    private int salaire;
    
    Infirmier(){
        numero = 0;
        code_service = "";
        rotation = "";
        salaire = 0;
    }
    
    Infirmier(int _numero, String _code_service, String _rotation, int _salaire){
        numero = _numero;
        code_service = _code_service;
        rotation = _rotation;
        salaire = _salaire;
    }

    public int getNumero() {
        return numero;
    }

    public String getCode_service() {
        return code_service;
    }

    public String getRotation() {
        return rotation;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCode_service(String code_service) {
        this.code_service = code_service;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
    
}
