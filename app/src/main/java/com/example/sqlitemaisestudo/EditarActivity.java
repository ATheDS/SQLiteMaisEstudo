package com.example.sqlitemaisestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity {
    public EditText nometext,cursotext,turnotext;
    public Banco db;
    public Button salvar;
    Integer IdAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        nometext = findViewById(R.id.nomeedittext);
        turnotext = findViewById(R.id.turnoedittext);
        cursotext = findViewById(R.id.cursosedittext);
        salvar = findViewById(R.id.salvar);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            IdAtual = extras.getInt("IdAtual");


            // and get whatever type user account id is
        }
        db = ((MaisEstudoApplication) this.getApplication()).getDb();
        nometext.setText(db.selecionarUser(IdAtual).getNome());
        turnotext.setText(db.selecionarUser(IdAtual).getTurno());
        cursotext.setText(db.selecionarUser(IdAtual).getCursos().toString());
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setUserString("turno",turnotext.getText().toString(),IdAtual);
                db.setUserString("nome",nometext.getText().toString(),IdAtual);
                db.setUserInt("cursos",Integer.parseInt(cursotext.getText().toString()),IdAtual);


                Intent intent = new Intent(EditarActivity.this,HomeActivity.class);
                intent.putExtra("IdAtual",IdAtual);
                startActivity(intent);
            }
        });


    }
}