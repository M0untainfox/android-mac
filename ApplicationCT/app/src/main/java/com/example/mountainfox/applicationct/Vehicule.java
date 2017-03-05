package com.example.mountainfox.applicationct;

/**
 * Created by Mountainfox on 15-Feb-17.
 */

public class Vehicule {

    public String Marque;
    public String Immatriculation;
    public String Modele;
    public int annee;
    public int km;
    public int type;



    public Vehicule(String mar,String mod,String imat,int an,int km,int type){
        Marque=mar;
        Modele=mod;
        Immatriculation= imat;
        annee = an;
        this.km=km;
        this.type= type;
    }
}
