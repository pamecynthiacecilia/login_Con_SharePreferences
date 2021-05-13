package com.nombreempresa.login_con_sharepreferences.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nombreempresa.login_con_sharepreferences.model.Usuario;
import com.nombreempresa.login_con_sharepreferences.request.ApiClient;

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
        ApiClient api= new ApiClient();
        api.guardar(context, usuario);
        mutableUsuario.setValue(usuario);

    }

   public void verRegistro(){
     Usuario usuario=  ApiClient.leer(context);
       mutableUsuario.setValue(usuario);
   }
}