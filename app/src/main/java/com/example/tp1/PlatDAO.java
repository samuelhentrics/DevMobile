package com.example.tp1;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class PlatDAO {
    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public PlatDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);

    }

    public Plat getPlat(long idP){
        Plat laPlat = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Plat where idP="+idP+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laPlat = new Plat(idP,curseur.getString(1), curseur.getLong(2));
        }
        return laPlat;
    }

    public void addPlat(Plat unePlat){
        Log.d("testLog","insert into Plat(libelleT,idC) values('"+unePlat.getLibelleP()+"',"+unePlat.getIdTP()+");");
        accesBD.getWritableDatabase().execSQL("insert into Plat(libelleT,idC) values('"+unePlat.getLibelleP()+"',"+unePlat.getIdTP()+");");
        accesBD.close();
    }

    public void delPlat(Plat unePlat){
        Log.d("testLog","delete from Plat where idT="+unePlat.getIdP()+";");
        accesBD.getWritableDatabase().execSQL("delete from Plat where idT="+unePlat.getIdP()+";");
        accesBD.close();
    }

    public ArrayList<Plat> getPlats(){
        Cursor curseur;
        String req = "select * from Plat;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToPlatArrayList(curseur);
    }
    public ArrayList<Plat> getPlatsByTypeplat(String nomTP){
        Cursor curseur;
        String req = "select * from Plat, categorie where Plat.idTP = categorie.idTP and nomTP='"+nomTP+"';";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToPlatArrayList(curseur);
    }



    private ArrayList<Plat> cursorToPlatArrayList(Cursor curseur){
        ArrayList<Plat> listePlats = new ArrayList<Plat>();
        long idP;
        String libelleT;
        long idTP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idP = curseur.getLong(0);
            libelleT = curseur.getString(1);
            idTP = curseur.getLong(2);
            listePlats.add(new Plat(idP,libelleT,idTP));
            curseur.moveToNext();
        }

        return listePlats;
    }
}
