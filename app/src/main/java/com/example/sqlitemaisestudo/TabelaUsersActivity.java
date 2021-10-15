package com.example.sqlitemaisestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TabelaUsersActivity extends AppCompatActivity {
    Banco db = new Banco(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_tabela_users);
    }
}