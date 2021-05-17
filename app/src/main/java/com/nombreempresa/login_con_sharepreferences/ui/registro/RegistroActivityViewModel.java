package com.nombreempresa.login_con_sharepreferences.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nombreempresa.login_con_sharepreferences.model.Usuario;
import com.nombreempresa.login_con_sharepreferences.request.ApiClient;
import com.nombreempresa.login_con_sharepreferences.ui.login.MainActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RegistroActivityViewModel extends AndroidViewModel {
    Context context;
    MutableLiveData<Usuario> mutableUsuario;


    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Usuario>getMutableUsuario(){
        if(mutableUsuario== null){
            mutableUsuario= new MutableLiveData<>();
        }
        return mutableUsuario;
    }



    public void guardarRegistro (long dni, String apellido , String nombre, String email, String password){

        Usuario usuario= new Usuario(dni,apellido,nombre,email,password);
        usuario.setDni(dni);
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);

        ApiClient.guardar(context, usuario);

        volverLogin();

    }


       public void verUsuarioRegistrado() {

        Usuario usuario = ApiClient.leer(context);
        mutableUsuario.setValue(usuario);

           }



   public void volverLogin(){
       Intent i = new Intent(context, MainActivity.class);
       i.addFlags(FLAG_ACTIVITY_NEW_TASK);
       context.startActivity(i);
   }
}