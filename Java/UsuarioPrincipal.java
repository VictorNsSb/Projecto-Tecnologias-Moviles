package com.example.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class UsuarioPrincipal extends AppCompatActivity {
   Button mAgregar;
    String [] productos = {
      "Limpiador en crema","Gel Tonico","Crema Hidratante","Crema Nutritiva Energizante","Tonico Astringente","Limpiador Mascarilla","Crema Aclarante Hidratante",
            "Crema Hidratante con color BB cream","Crema Hidratante Cream Matt","Exfoliante Energizante","Mascarilla Purificante","Desmaquillador Agua Micelar","Desmaquillador Doble Fase para rostro y ojos",
            "Desmaquillador para ojos y fortalecedor de pestañas","Crema Rostro Totalist Aloe Vera","Crema Rostro Totalist Concha de Nacar","Bloqueador SPF 100","Bloqueador SPF 100 Compacto",
            "Bloqueador Total Block Anti-Edad Matt SPF 50","Bloqueador Total Block Kids SPF 70","Bloqueador Total Block Repelente SPF 50"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_principal);

        mAgregar = (Button) findViewById(R.id.btnAgregarProducto);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, productos);
        AutoCompleteTextView txtProductos = (AutoCompleteTextView) findViewById(R.id.txtProducto);
        txtProductos.setThreshold(3);
        txtProductos.setAdapter(adapter);

        VideoView videoView = findViewById(R.id.video_usuario);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.tips_maquillaje;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        mAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent("com.example.AgregarProductos"));
            }
        });
    }

    public void buscarProducto(View view) {
        startActivity(new Intent("com.example.Productos"));
    }

    public void mostrarProductos(View view){
        startActivity(new Intent("com.example.ProductosLista"));
    }
}
