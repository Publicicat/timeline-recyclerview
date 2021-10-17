package com.publicicat.mismascotasdos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //List of pets: declaration
    ArrayList<ConstructorMascota> mascotas;

    //Recycler view from activity_main: declaration 1/2
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button goTop5 = (Button) findViewById(R.id.go_Top5);

        //Custom Action Bar: from here
        ImageView leftIcon = (ImageView) findViewById(R.id.left_icon);
        ImageView rightIcon = (ImageView) findViewById(R.id.right_icon);
        TextView title = (TextView) findViewById(R.id.title_custom_action_bar);

        leftIcon.setVisibility(View.GONE);
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
                title.setText("Easy Tutorial");
            }
        });

        //Nav to second activity: from here
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked in 5-Star icon", Toast.LENGTH_SHORT).show();
                Intent iTop5 = new Intent(MainActivity.this, top_five.class);
                startActivity(iTop5);
                finish();

            }
        });
        //Nav to second activity: to here
        //Custom Action Bar: to here

        //Implicit intent to take a picture from camera: from here
        FloatingActionButton tkPic = (FloatingActionButton) findViewById(R.id.fab_tk_pic);
        tkPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera is not ready yet", Toast.LENGTH_SHORT).show();
                title.setText("Dress up your pet, fellow");
            }
        });
        //Implicit intent to take a picture from camera: to here

        //Recycler view from activity_main: declaration 2/2
        rvMascotas = (RecyclerView) findViewById(R.id.rv_Mascotas);
        LinearLayoutManager LinLayMan = new LinearLayoutManager(this);
        LinLayMan.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(LinLayMan);
        inicializarListaMascotas();
        inicializarAdaptador();

        /*GridLayoutManager glm = new GridLayoutManager(this,2);
        rvMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptadorRVMain();*/


    } //On create ends

    public void inicializarListaMascotas() {
        //List of pets: from here
        mascotas = new ArrayList<ConstructorMascota>();

        mascotas.add(new ConstructorMascota("Fisherpet fish", 41, R.drawable.fish_louis_hall));
        mascotas.add(new ConstructorMascota("Ham hamster", 12, R.drawable.hamster_ricardo_rodriguez));
        mascotas.add(new ConstructorMascota("Purr cat", 44, R.drawable.yuki_the_cat_emrah_errr));
        mascotas.add(new ConstructorMascota("Frankenstein dog", 21, R.drawable.dog_sidiney_carlos));
        mascotas.add(new ConstructorMascota("Thin & Fat turtles", 87, R.drawable.turtles_bjorn_graaf));
        //List of pets: to here
    }

    //Adaptador para la clase anidada: declaration
    //public MascotaAdaptador adaptadorRVMain;
    public void inicializarAdaptador(){
        MascotaAdaptador adaptadorRVMain = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptadorRVMain);
    }


}