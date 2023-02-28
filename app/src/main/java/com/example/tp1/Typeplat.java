package com.example.tp1;

public class Typeplat {

    private long idTP;

    private String libelleTP;

    public Typeplat(long idTP, String libelleTP) {
        this.idTP = idTP;
        this.libelleTP = libelleTP;
    }

    public long getIdTP() {
        return idTP;
    }

    public void setIdTP(long idTP) {
        this.idTP = idTP;
    }

    public String getLibelleTP() {
        return libelleTP;
    }

    public void setLibelleTP(String libelleTP) {
        this.libelleTP = libelleTP;
    }
}
