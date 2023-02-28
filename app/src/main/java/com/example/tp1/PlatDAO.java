package com.example.tp1;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class PlatDAO {

    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public PlatDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Plat getPlat(long idP){
        Plat lePlat = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from plat where idP="+idP+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            lePlat = new Plat(idP,curseur.getString(1),1);
        }
        return lePlat;
    }

    public ArrayList<Plat> getPlats(){
        Cursor curseur;
        String req = "select * from plat;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToPlatArrayList(curseur);
    }

    private ArrayList<Plat> cursorToPlatArrayList(Cursor curseur){
        ArrayList<Plat> listePlat = new ArrayList<Plat>();
        long idP;
        String libelleP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            idP = curseur.getLong(0);
            libelleP = curseur.getString(1);
            listePlat.add(new Plat(idP,libelleP,1));
            curseur.moveToNext();
        }
        return listePlat;
    }


}
