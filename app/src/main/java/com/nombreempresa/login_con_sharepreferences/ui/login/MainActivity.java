package com.nombreempresa.login_con_sharepreferences.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nombreempresa.login_con_sharepreferences.R;

public class MainActivity extends AppCompatActivity {
    private Button iniciar,registro ;
    private EditText usuario, pass;
    private   MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializar();

    }

    private void inicializar(){
        iniciar= findViewById(R.id.btInicio);
        registro=findViewById(R.id.btRegistro);
        usuario=findViewById(R.id.etUsuario);
        pass=findViewById(R.id.etClave);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.llamaRegistro();

            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.llamaRegistro();
            }
        });

    }
}