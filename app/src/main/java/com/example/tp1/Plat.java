package com.example.tp1;

public class Plat {
    private long idP;
    private String libelleP;

    private long idTP;

    public Plat(long idP, String libelleP, long idTP) {
        setIdP(idP);
        setLibelleP(libelleP);
        setIdTP(idTP);
    }

    public long getIdP() {
        return idP;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }

    public long getIdTP() {
        return idTP;
    }

    public void setIdTP(long idTP) {
        this.idTP = idTP;
    }
}
