package com.example.tp1;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class TypeplatDAO {

    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public TypeplatDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Typeplat getTypeplat(long idTP){
        Typeplat leTypeplat = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from typeplat where idTP="+idTP+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leTypeplat = new Typeplat(idTP,curseur.getString(1));
        }
        return leTypeplat;
    }

    public ArrayList<Typeplat> getTypesplat(){
        Cursor curseur;
        String req = "select * from typeplat;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToTypeplatArrayList(curseur);
    }

    private ArrayList<Typeplat> cursorToTypeplatArrayList(Cursor curseur){
        ArrayList<Typeplat> listeTypeplat = new ArrayList<Typeplat>();
        long idTP;
        String libelleTP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idTP = curseur.getLong(0);
            libelleTP = curseur.getString(1);
            listeTypeplat.add(new Typeplat(idTP,libelleTP));
            curseur.moveToNext();
        }
        return listeTypeplat;
    }


}
