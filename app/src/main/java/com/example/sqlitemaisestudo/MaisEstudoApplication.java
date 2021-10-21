package com.example.sqlitemaisestudo;

import android.app.Application;

public class MaisEstudoApplication extends Application {
    public Banco db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = new Banco(this);


    }

    public Banco getDb() {
        return db;
    }
}
