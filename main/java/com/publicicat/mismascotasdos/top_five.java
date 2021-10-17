package com.publicicat.mismascotasdos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class top_five extends AppCompatActivity {

    //List of pets: declaration
    ArrayList<ConstructorMascota> mascotas;

    //Recycler view from activity_main: declaration 1/2
    private RecyclerView rvTopFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_top);

        //Custom Action Bar: from here
        ImageView rightIcon = (ImageView) findViewById(R.id.right_icon);
        ImageView leftIcon = (ImageView) findViewById(R.id.left_icon);
        TextView title = (TextView) findViewById(R.id.title_custom_action_bar);

        rightIcon.setVisibility(View.GONE);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(top_five.this, "Back to Main Activity", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(top_five.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        //Custom Action Bar: to here

        //Recycler view from activity_main: declaration 2/2
        rvTopFive = (RecyclerView) findViewById(R.id.rv_TopFive);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvTopFive.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();



    } //On create ends

    public void inicializarListaMascotas() {
        //List of pets: from here
        mascotas = new ArrayList<ConstructorMascota>();

        mascotas.add(new ConstructorMascota("Thin & Fat turtles", 87, R.drawable.turtles_bjorn_graaf));
        mascotas.add(new ConstructorMascota("Fisherpet fish", 41, R.drawable.fish_louis_hall));
        mascotas.add(new ConstructorMascota("Purr cat", 44, R.drawable.yuki_the_cat_emrah_errr));
        mascotas.add(new ConstructorMascota("Frankenstein dog", 21, R.drawable.dog_sidiney_carlos));
        mascotas.add(new ConstructorMascota("Ham hamster", 12, R.drawable.hamster_ricardo_rodriguez));

        //List of pets: to here
    }

    //Adaptador para la clase anidada: declaration
    //public MascotaAdaptador adaptadorRVMain;
    public void inicializarAdaptador(){
        MascotaAdaptador adaptadorTf = new MascotaAdaptador(mascotas, this);
        rvTopFive.setAdapter(adaptadorTf);
    }


}