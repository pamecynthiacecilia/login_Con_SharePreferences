package com.nombreempresa.login_con_sharepreferences.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.nombreempresa.login_con_sharepreferences.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context contex){
        if(sp==null){
            sp=contex.getSharedPreferences("datos",0);
        }
        return sp;
    }

public static void guardar(Context contex, Usuario u)   {
        SharedPreferences sp=conectar(contex);
        SharedPreferences.Editor editor=sp.edit();
        editor.putLong("dni",u.getDni());
        editor.putString("apellido", u.getApellido());
        editor.putString("nombre", u.getNombre());
        editor.putString("email", u.getEmail());
        editor.putString("password", u.getPassword());
        editor.commit();

    }
    public static Usuario leer(Context context){

        SharedPreferences sp=conectar(context);
        Long dni=sp.getLong("dni",-1);
        String apellido=sp.getString("apellido", "no hay dato");
        String nombre=sp.getString("nombre", "no hay dato");
        String email=sp.getString("email", "no hay dato");
        String password=sp.getString("password", "no hay dato");

        Usuario u= new Usuario(dni,apellido,nombre,email,password);

        return u;
    }
    public static Usuario login(Context contex, String mail, String pass){
        Usuario u= null;
        SharedPreferences sp=conectar(contex);
        Long dni=sp.getLong("dni",-1);
        String apellido=sp.getString("apellido", "no hay dato");
        String nombre=sp.getString("nombre", "no hay dato");
        String email=sp.getString("email", "no hay dato");
        String password=sp.getString("password", "no hay dato");

        if(mail.equals(email) && pass.equals(password)){
            u= new Usuario(dni,apellido,nombre,email,password);

        }

        return  u;   //if(mail== email && pass==password)

    }


}
