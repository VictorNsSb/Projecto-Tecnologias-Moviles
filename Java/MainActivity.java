package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends Activity {
    EditText mTextUsername, mTextPassword;
    Button mButtonLogin,mButtonRegistro,mButtonContacto;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.etUsuario);
        mTextPassword = (EditText)findViewById(R.id.etPass);
        mButtonLogin = (Button)findViewById(R.id.btnIngresar);
        mButtonRegistro = (Button)findViewById(R.id.btnRegistro);
        mButtonContacto = (Button)findViewById(R.id.btnContactanos);

        mButtonRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent("com.example.Registro"));
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    startActivity(new Intent("com.example.UsuarioPrincipal"));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Usuario/Contraseña incorrecta",Toast.LENGTH_LONG).show();
                }
            }
        });

        mButtonContacto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent("com.example.Contactanos"));
            }
        });
    }
}
