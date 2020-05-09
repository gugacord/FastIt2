package com.delivery.fastit;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import java.security.PublicKey;
import java.util.jar.Attributes;

public class User {
    private String phone;
    private String name;
    private String password;
    private String cpf;
    private String email;

    public User(String phone, String name, String password, String email, String cpf){
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}