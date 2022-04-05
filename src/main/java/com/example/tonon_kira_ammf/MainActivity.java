package com.example.tonon_kira_ammf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button hitady;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert data to database
         databaseManager = new DatabaseManager(this);
         databaseManager.deleteAll();
         databaseManager.close();
         Cursor check = databaseManager.getALl();
         if (check.getCount() == 0){

             databaseManager.insertHira("Fitiavana mandrakizay","Andro tsotra","fitiavana_mandrakizay");
             databaseManager.insertHira("I Jesoa velona","Paka","i_jesoa_velona");
             databaseManager.insertHira("Mankalaza","Paka","mankalaza");
             databaseManager.insertHira("Ilay mpiandry ahy","Karemy","ilay_mpiandry_ahy");
             databaseManager.insertHira("Jesoa teny tonga nofo","Krismasy","jesoa_teny_tonga_nofo");
             databaseManager.insertHira("Efa avotrao","Andro tsotra","efa_avotrao");
             databaseManager.insertHira("Manompo anao","Avant","manompo_anao");
             databaseManager.insertHira("Masina Maria","Pantekoty","masina_maria");
             databaseManager.close();
         }

        hitady = findViewById(R.id.hitady);

        hitady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(),Hitady.class);
                startActivity(i);
            }
        });

    }
}