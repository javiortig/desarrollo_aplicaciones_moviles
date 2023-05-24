package com.example.t11navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    //Definimos los parámetros de la db
    private Context context;
    private static final String DATABASE_NAME= "Juegos.db";
    private static final int DATABASE_VERSION=8;
    static ArrayList<ModelJuego> carrito = new ArrayList<>();

    /* Estructura de la DB:
    *   TABLE juegos (
    *       id INTEGER PK
    *       name TEXT
    *       precio INTEGER
    *       image BLOB
    *       platform TEXT
    *       )
    *           */

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    //Constantes tabla
    private static final String TABLE_NAME="juegos";

    private static final String COLUMN_NAME="name";
    private static final String COLUMN_PRICE="price";
    private static final String COLUMN_IMAGE="image";
    private static final String COLUMN_PLATFORM="platform";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=
                "CREATE TABLE IF NOT EXISTS "  + TABLE_NAME + "(" +
                        "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_PRICE + " INTEGER, " +
                        COLUMN_IMAGE + " BLOB, "+
                        COLUMN_PLATFORM+" TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String name, int price, byte[] img, String platform){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_PRICE, price);
        cv.put(COLUMN_IMAGE, img);
        cv.put(COLUMN_PLATFORM, platform);
        
        long ins = MyDB.insert(TABLE_NAME, null, cv);
        if(ins==-1) return false;
        else return true;
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM "  +TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
