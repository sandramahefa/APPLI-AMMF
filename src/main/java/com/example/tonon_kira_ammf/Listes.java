package com.example.tonon_kira_ammf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Listes extends AppCompatActivity {
    TextView lohateny;
    private DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listes);

        ListView listHiraByLohateny = findViewById(R.id.listes_view);
        Intent i = getIntent();
        String lohateny = i.getStringExtra("lohateny");
        //   Raha lohateny;
        List arrayListHIraLohateny = viewAllLohateny(lohateny);


        listHiraByLohateny.setAdapter(new ListAdapter(this, arrayListHIraLohateny));
        listHiraByLohateny.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hira item_hira = (Hira) arrayListHIraLohateny.get(i);
                Intent intent = new Intent(view.getContext(),Details_hira.class);
                intent.putExtra("lohateny_detail",item_hira.getLohateny());
                intent.putExtra("anarana_detail", item_hira.getAnarana());
                startActivity(intent);
            }
        });

        //Raha sokajy
//        List arrayListHiraSokajy = viewAllBySokajy(sokajy);
//        listHiraBySokajy.setAdapter(new ListAdapter(this, arrayListHiraSokajy));
//        listHiraBySokajy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Hira item_hira = (Hira) arrayListHiraSokajy.get(i);
//                Intent intent = new Intent(view.getContext(),Details_hira.class);
//                intent.putExtra("lohateny_detail",item_hira.getLohateny());
//                intent.putExtra("anarana_detail", item_hira.getAnarana());
//                startActivity(intent);
//            }
//        });
    }
    private List viewAllLohateny(String lohateny){
        List<Hira> listeHira= new ArrayList<Hira>();
        databaseManager = new DatabaseManager(this);
        Cursor res = databaseManager.getLOhateny(lohateny);
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

//    private List viewAllBySokajy(String sokajy){
//        List<Hira> listeHira= new ArrayList<Hira>();
//        databaseManager = new DatabaseManager(this);
//        Cursor res = databaseManager.getSokajy(sokajy);
//        if(res.getCount() ==0){
//            //tsy misy
//            showMessage("DATA", "vide");
//        }else{
//
//            while (res.moveToNext()){
//                Hira hira = new Hira(res.getInt(0),res.getString(1),res.getString(2),res.getString(3));
//
//                listeHira.add(hira);
//            }
//            //show all data
//            //showMessage("DATA", "non vide");
//        }
//        return listeHira;
//    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}