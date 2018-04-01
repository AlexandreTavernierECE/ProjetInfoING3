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
public class Hospitalisation {
    private int num_malade;
    private int code_service;
    private int num_chambre;
    private int lit;

    public Hospitalisation(int _num_malade, int _code_service, int _num_chambre, int _lit) {
        num_malade = _num_malade;
        code_service = _code_service;
        num_chambre = _num_chambre;
        lit = _lit;
    }
    
     public Hospitalisation() {
        num_malade = 0;
        code_service = 0;
        num_chambre = 0;
        lit = 0;
    }

    public int getNum_malade() {
        return num_malade;
    }

    public int getCode_service() {
        return code_service;
    }

    public int getNum_chambre() {
        return num_chambre;
    }

    public int getLit() {
        return lit;
    }

    public void setNum_malade(int num_malade) {
        this.num_malade = num_malade;
    }

    public void setCode_service(int code_service) {
        this.code_service = code_service;
    }

    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    public void setLit(int lit) {
        this.lit = lit;
    }
    
    
}
