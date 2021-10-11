package com.example.sqlitemaisestudo;

import android.widget.Button;

import java.io.Serializable;

public class User implements Serializable {
    public String email;
    public String nome;
    public String uid;
    public Integer cursos;
    public String turno;
    public Integer atividades;

    public Integer getAtividades() {
        return atividades;
    }
    public void IncrementarAtividades(int i){
        this.atividades = atividades+i;
    }

    public void setAtividades(Integer atividades) {
        this.atividades = atividades;
    }

    public User(Integer atividades) {
        this.atividades = atividades;
    }

    public Button getBotaomais() {
        return botaomais;
    }

    public void setBotaomais(Button botaomais) {
        this.botaomais = botaomais;
    }

    public Button getBotaomenos() {
        return botaomenos;
    }

    public void setBotaomenos(Button botaomenos) {
        this.botaomenos = botaomenos;
    }

    public Button botaomais;
    public Button botaomenos;

    public String getTurno() {
        return turno;
    }

    public User(Button botaomais, Button botaomenos) {
        this.botaomais = botaomais;
        this.botaomenos = botaomenos;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public User(String email, String nome, String uid, Integer cursos) {
        this.email = email;
        this.nome = nome;
        this.uid = uid;
        this.cursos = cursos;
    }

    public User() {

    }

    public Integer getCursos() {
        return cursos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCursos(Integer cursos) {
        this.cursos = cursos;
    }
}

