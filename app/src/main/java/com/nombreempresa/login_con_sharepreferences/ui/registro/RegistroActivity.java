package com.nombreempresa.login_con_sharepreferences.ui.registro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nombreempresa.login_con_sharepreferences.R;
import com.nombreempresa.login_con_sharepreferences.model.Usuario;


public class RegistroActivity extends AppCompatActivity {
    private EditText dni, apellido, nombre, email, password;
    private Button guardar;
    private RegistroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        inicializar();

        vm.getMutableUsuario().observe(this, new Observer<Usuario>() {
                    @Override
                    public void onChanged(Usuario usuario) {
                        dni.setText(usuario.getDni()+"");
                        apellido.setText(usuario.getApellido());
                        nombre.setText(usuario.getNombre());
                        email.setText(usuario.getEmail());
                        password.setText(usuario.getPassword());


                    }
                });


    }

    public void inicializar(){
        dni= findViewById(R.id.etDni);
        apellido=findViewById(R.id.etApellido);
        nombre=findViewById(R.id.etNombre);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        guardar=findViewById(R.id.btGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            vm.guardarRegistro((Long.valueOf(dni.getText().toString())),(apellido.getText().toString()), (nombre.getText().toString()),(email.getText().toString()),(password.getText().toString()));
           // vm.verRegistro();

            }

        });


    }
}

