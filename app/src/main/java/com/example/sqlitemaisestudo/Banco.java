package com.example.sqlitemaisestudo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_USER = "bd_users";

    private static final String TABELA_USER = "tb_users";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_TURNO = "turno";
    private static final String COLUNA_CURSOS = "cursos";
    private static final String COLUNA_ATIVIDADES = "atividades";



    public Banco( Context context) {
        super(context, BANCO_USER, null, VERSAO_BANCO   );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_users("+ COLUNA_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , nome VARCHAR, email VARCHAR,cursos INTEGER, turno VARCHAR, atividades INTEGER, UNIQUE(email,nome))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
    void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("tb_users",new String[]{COLUNA_ID,"email","nome","cursos","turno","atividades"},
                COLUNA_ID+ " = ?",
                new String[]{COLUNA_ID},null,null,null,null);
        if(cursor !=null){
            cursor.moveToFirst();
        }



        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, user.getNome());
        values.put(COLUNA_EMAIL, user.getEmail());
        values.put(COLUNA_CURSOS, user.getCursos());
        values.put(COLUNA_TURNO, user.getTurno());
        values.put(COLUNA_ATIVIDADES, user.getAtividades());
        db.insert(TABELA_USER,null,values);







        db.close();


    }
    public User selecionarUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("tb_users",new String[]{COLUNA_ID,"email","nome","cursos","turno","atividades"},
                COLUNA_ID+ " = ?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor !=null){
            cursor.moveToFirst();
        }
        return new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getInt(5));

    }


}
