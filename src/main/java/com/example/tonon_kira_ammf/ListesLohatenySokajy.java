package com.example.tonon_kira_ammf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListesLohatenySokajy extends AppCompatActivity {
    private DatabaseManager databaseManager;
    private String lohateny_sokajy;
    private String sokajy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listes_lohateny_sokajy);

        ListView listHiraBySokajy = findViewById(R.id.listes_view_lohateny_sokajy);
        Intent i = getIntent();
        sokajy = i.getStringExtra("ch_sokajy");
        lohateny_sokajy = i.getStringExtra("lohateny_sokajy");

        List arrayListHIraSokajy = viewAllByLohatenySokajy(lohateny_sokajy, sokajy);

        listHiraBySokajy.setAdapter(new ListAdapter(this, arrayListHIraSokajy));
        listHiraBySokajy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hira item_hira = (Hira) arrayListHIraSokajy.get(i);
                Intent intent = new Intent(view.getContext(),Details_hira.class);
                intent.putExtra("lohateny_detail",item_hira.getLohateny());
                intent.putExtra("anarana_detail", item_hira.getAnarana());
                startActivity(intent);
            }
        });
    }
    private List viewAllByLohatenySokajy(String lohateny_sokajy,String sokajy){
        List<Hira> listeHira= new ArrayList<Hira>();
        databaseManager = new DatabaseManager(this);
        Cursor res = databaseManager.getLohatenySokajy(lohateny_sokajy,sokajy);
        if(res.getCount() ==0){
            //tsy misy
            showMessage("Message", "Tsy misy");
        }else{
            //StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()){
                Hira hira = new Hira(res.getInt(0),res.getString(1),res.getString(2),res.getString(3));

                listeHira.add(hira);
//                        buffer.append("id_hira:" +  res.getString(0)+"\n");
//                        buffer.append("lohateny:" +  res.getString(1)+"\n");
//                        buffer.append("sokajy:" +  res.getString(2)+"\n");
//                        buffer.append("anarana:" +  res.getString(3)+"\n");
            }
            //show all data
            //showMessage("DATA", "non vide");
        }

        return listeHira;

    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}