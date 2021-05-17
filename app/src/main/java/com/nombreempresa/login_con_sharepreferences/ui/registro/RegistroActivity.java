package com.nombreempresa.login_con_sharepreferences.ui.registro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nombreempresa.login_con_sharepreferences.R;
import com.nombreempresa.login_con_sharepreferences.model.Usuario;
import com.nombreempresa.login_con_sharepreferences.request.ApiClient;


public class RegistroActivity extends AppCompatActivity {
    private EditText dni, apellido, nombre, email, password;
    private Button guardar;
    private RegistroActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializar();

        vm.getMutableUsuario().observe(this, new Observer<Usuario>() {
                    @Override
                    public void onChanged(Usuario usuario) {
                        dni.setText(usuario.getDni() + "");
                        nombre.setText(usuario.getNombre());
                        apellido.setText(usuario.getApellido());
                        email.setText(usuario.getEmail());
                        password.setText(usuario.getPassword());

                    }
                });

        Bundle datos = this.getIntent().getExtras();
        if(datos!=null) {

            usuarioRegistrado();
        }

    }

    public void inicializar(){
        dni= findViewById(R.id.etDni);
        apellido=findViewById(R.id.etApellido);
        nombre=findViewById(R.id.etNombre);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        guardar=findViewById(R.id.btGuardar);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            vm.guardarRegistro(Long.parseLong(((dni.getText().toString()))),(apellido.getText().toString()), (nombre.getText().toString()),(email.getText().toString()),(password.getText().toString()));


            }

        });
    }
public void  usuarioRegistrado(){

  vm.verUsuarioRegistrado();
}

    }