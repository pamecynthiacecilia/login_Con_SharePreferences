package com.nombreempresa.login_con_sharepreferences.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.nombreempresa.login_con_sharepreferences.ui.registro.RegistroActivity;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class MainActivityViewModel extends AndroidViewModel {
    Context context;


 public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


    public void llamaRegistro() {
        Intent i = new Intent(context, RegistroActivity.class);
        i.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
