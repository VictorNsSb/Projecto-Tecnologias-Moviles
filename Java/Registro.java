package com.example.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.etUsuario);
        mTextPassword = (EditText)findViewById(R.id.etPass);
        mTextCnfPassword = (EditText)findViewById(R.id.etConfPass);
        mButtonRegister = (Button)findViewById(R.id.btnRegistrar);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(Registro.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Registro.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(Registro.this,"Error en el Registro",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Registro.this,"Contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
