package com.nombreempresa.login_con_sharepreferences.ui.login;

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
import com.nombreempresa.login_con_sharepreferences.ui.registro.RegistroActivity;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class MainActivityViewModel extends AndroidViewModel {
    Context context;
    MutableLiveData<Usuario> mutableUsuario;
    MutableLiveData<String> mutableMensaje;


 public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Usuario> getMutableUsuario(){
        if(mutableUsuario== null){
            mutableUsuario= new MutableLiveData<>();
        }
        return mutableUsuario;
    }

    public LiveData<String> getMutableMensaje(){
        if(mutableMensaje== null){
            mutableMensaje= new MutableLiveData<>();
        }
        return mutableMensaje;
    }


    public void llamaRegistro() {

        Intent i = new Intent(context, RegistroActivity.class);
        i.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public void controlLogin (String mail, String pass) {
        SharedPreferences sp=context.getSharedPreferences("datos",0);

        String email=sp.getString("email", "no hay dato");
        String password=sp.getString("password", "no hay dato");

        if(mail.equals(email) && pass.equals(password)){

         Usuario u= ApiClient.login(context, mail, pass);

         mutableUsuario.setValue(u);

        }
        else mutableMensaje.setValue("Usuario y/o clave incorrectos");


        }


    }
