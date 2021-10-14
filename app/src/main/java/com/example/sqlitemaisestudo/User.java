package com.example.sqlitemaisestudo;

import android.widget.Button;

import java.io.Serializable;

public class User implements Serializable {
    public String email;
    public String nome;
    public int uid;
    public Integer cursos;


    public User(){
    }



    public User(int uid,String email, String nome, Integer cursos, String turno, Integer atividades) {
        this.email = email;
        this.nome = nome;
        this.uid = uid;
        this.cursos = cursos;
        this.turno = turno;
        this.atividades = atividades;
    }
    public User(String email, String nome, Integer cursos, String turno, Integer atividades) {
        this.email = email;
        this.nome = nome;
        this.cursos = cursos;
        this.turno = turno;
        this.atividades = atividades;
    }

    public String turno;
    public Integer atividades;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Integer getCursos() {
        return cursos;
    }

    public void setCursos(Integer cursos) {
        this.cursos = cursos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getAtividades() {
        return atividades;
    }

    public void setAtividades(Integer atividades) {
        this.atividades = atividades;
    }


}