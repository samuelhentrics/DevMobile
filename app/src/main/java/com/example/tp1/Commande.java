package com.example.tp1;

import java.util.Hashtable;

public class Commande {
    private Hashtable<String,Integer> lesPlats;
    private Hashtable<String,Integer> lesEntrees ;
    private Hashtable<String,Integer> lesDesserts ;
    private String remarques ;

    public Commande() {
        lesPlats  = new Hashtable<String,Integer>();
        lesEntrees = new Hashtable<String,Integer>();
        lesDesserts = new Hashtable<String,Integer>();
        remarques="";
    }

    public Hashtable<String, Integer> getLesPlats() {
        return lesPlats;
    }

    public void setLesPlats(Hashtable<String, Integer> lesPlats) {
        this.lesPlats = lesPlats;
    }

    public Hashtable<String, Integer> getLesEntrees() {
        return lesEntrees;
    }

    public void setLesEntrees(Hashtable<String, Integer> lesEntrees) {
        this.lesEntrees = lesEntrees;
    }

    public Hashtable<String, Integer> getLesDesserts() {
        return lesDesserts;
    }

    public void setLesDesserts(Hashtable<String, Integer> lesDesserts) {
        this.lesDesserts = lesDesserts;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}

