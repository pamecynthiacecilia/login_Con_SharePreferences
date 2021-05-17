package com.nombreempresa.login_con_sharepreferences.model;

public class Usuario {
    private long dni;
    private String apellido;
    private String nombre;
    private String email;
    private String password;

    public Usuario(long dni,String apellido, String nombre,String email,String password){
        this.dni=dni;
        this.apellido=apellido;
        this.nombre=nombre;
        this.email=email;
        this.password=password;
    }
    public Usuario(){}


    public long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Usuario{" +
                "dni = " + dni +
                ", apellido ='"+ apellido +'\'' +
                ", nombre ='"+ nombre +'\'' +
                ", email ='"+ email +'\'' +
                ", password ='"+ password +'\'' +
                '}';



    }
}


