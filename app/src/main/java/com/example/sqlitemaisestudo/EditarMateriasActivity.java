package com.example.sqlitemaisestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditarMateriasActivity extends AppCompatActivity {
    public Banco db;
    public int IdAtual;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = ((MaisEstudoApplication) this.getApplication()).getDb();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            IdAtual = bundle.getInt("IdAtual");
        }

        setContentView(R.layout.activity_editar_materias);
        userList =  findViewById(R.id.listView);

                viewData();
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(EditarMateriasActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        for(int x = 1;x<=db.getDbSize();x++){
            Log.d("a",db.selecionarUser(x).getNome());
            Log.d("a",db.getAllUserData(x));
        }
    }

    private void viewData() {
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }
        }
        adapter = new ArrayAdapter<>(this,R.layout.row_users,listItem);
        userList.setAdapter(adapter);


    }
}