package com.example.sqlitemaisestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class EditarMateriasActivity extends AppCompatActivity {
    public Banco db;
    public int IdAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = ((MaisEstudoApplication) this.getApplication()).getDb();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            IdAtual = bundle.getInt("IdAtual");
        }

        setContentView(R.layout.activity_editar_materias);
        for(int x = 1;x<=db.getDbSize();x++){
            Log.d("a",db.selecionarUser(x).getNome());
            Log.d("a",db.getAllUserData(x));
        }
    }
}