package com.nombreempresa.login_con_sharepreferences.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nombreempresa.login_con_sharepreferences.R;
import com.nombreempresa.login_con_sharepreferences.model.Usuario;
import com.nombreempresa.login_con_sharepreferences.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private Button inicioSesion,registro ;
    private EditText email, pass;
    private   MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializar();

        vm.getMutableUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {

                verUsuarioActual();
              /* String mail= usuario.getEmail();
               String pass= usuario.getPassword();

              verUsuarioActual(mail, pass);*/
               // vm.llamaRegistro(usuario.getEmail(),usuario.getPassword());
            }
        });

        vm.getMutableMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Advertencia")
                        .setMessage(mensaje)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });

    }

    private void inicializar(){
        inicioSesion= findViewById(R.id.btInicio);
        registro=findViewById(R.id.btRegistro);
        email=findViewById(R.id.etUsuario);
        pass=findViewById(R.id.etClave);

        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              vm.controlLogin(email.getText().toString(),pass.getText().toString());


            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.llamaRegistro();
            }
        });

    }
    public void verUsuarioActual(){
        Intent intent = new Intent(this, RegistroActivity.class);
        intent.putExtra("login","usuarioActual");
        startActivity(intent);

 /*public void verUsuarioActual(String correo, String clave){
     Intent intent = new Intent(this, RegistroActivity.class);
     intent.putExtra("usuario", correo);
     intent.putExtra("clave", clave);

     startActivity(intent);*/
 }

}