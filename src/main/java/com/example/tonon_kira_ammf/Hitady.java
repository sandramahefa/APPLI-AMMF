package com.example.tonon_kira_ammf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Hitady extends AppCompatActivity {

    ImageButton chercher;
    TextView lohateny;
    //image button variable
    ImageView krismasy, karemy, avant , paka, androtsotra, pantekoty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitady);



        lohateny = findViewById(R.id.lohateny);
        chercher =(ImageButton) findViewById(R.id.ch);
        krismasy = (ImageView) findViewById(R.id.krismasy);
        karemy = (ImageView) findViewById(R.id.karemy);
        avant = (ImageView) findViewById(R.id.avant);
        paka = (ImageView) findViewById(R.id.paka);
        pantekoty= (ImageView) findViewById(R.id.pantekoty);
        androtsotra = (ImageView) findViewById(R.id.androtsotra);



        chercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Listes.class);
                i.putExtra("lohateny",lohateny.getText().toString());
                startActivity(i);
            }
        });

      //  click image button
        krismasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Krismasy");
                startActivity(i);
            }
        });

        karemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Karemy");
                startActivity(i);
            }
        });

        avant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Avant");
                startActivity(i);
            }
        });

        paka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Paka");
                startActivity(i);
            }
        });
        pantekoty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Pantekoty");
                startActivity(i);
            }
        });

        androtsotra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListesSokajy.class);
                i.putExtra("sokajy","Andro tsotra");
                startActivity(i);
            }
        });


    }

}