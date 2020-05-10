package com.delivery.fastit;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import java.security.PublicKey;
import java.util.jar.Attributes;

public class User {
    private String phone;
    private String Name;
    private String Password;
    private String CPF;
    private String Email;

    public User() {

    }

    public User(String phone, String name, String password, String email, String cpf){
        this.phone = phone;
        this.Name = name;
        this.Password = password;
        this.CPF = cpf;
        this.Email = email;
    }

    public User(String email, String cpf, String name, String password){
        this.Name = name;
        this.Password = password;
        this.CPF = cpf;
        this.Email = email;
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }


    public String getPassword(){
        return this.Password;
    }

    public void setPassword(String password){
        this.Password = password;
    }


    public String getCpf(){
        return this.CPF;
    }

    public void setCpf(String cpf){
        this.CPF = cpf;
    }


    public String getEmail(){
        return this.Email;
    }

    public void setEmail(String email){
        this.Email = email;
    }
}