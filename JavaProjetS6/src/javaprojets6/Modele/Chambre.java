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
public class Chambre {
    private int num_chambre;
    private int code_service;
    private String surveillant;
    private int num_lit;
    
    Chambre(){
        num_chambre = 0;
        code_service = 0;
        surveillant = "";
        num_lit = 0;
    }
    
    Chambre(int _num_chambre, int _code_service, String _surveillant, int _num_lit){
        num_chambre = _num_chambre;
        code_service = _code_service;
        surveillant = _surveillant;
        num_lit = _num_lit;
    }

    public int getNum_chambre() {
        return num_chambre;
    }

    public int getCode_service() {
        return code_service;
    }

    public String getSurveillant() {
        return surveillant;
    }

    public int getNum_lit() {
        return num_lit;
    }

    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    public void setCode_service(int code_service) {
        this.code_service = code_service;
    }

    public void setSurveillant(String surveillant) {
        this.surveillant = surveillant;
    }

    public void setNum_lit(int num_lit) {
        this.num_lit = num_lit;
    }
    
    
}
