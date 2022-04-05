package com.example.tonon_kira_ammf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_hira extends AppCompatActivity {
    private String lohateny_detail;
    private String anarana_detail;
    private TextView lohateny_detail_view;
    private ImageView tononkira_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_hira);

        Intent i = getIntent();
        lohateny_detail = i.getStringExtra("lohateny_detail");
        anarana_detail = i.getStringExtra("anarana_detail");

        lohateny_detail_view = findViewById(R.id.detail_lohateny);

//      //set image detail
        tononkira_image = findViewById(R.id.detail_image);
        int srId = getResources().getIdentifier(anarana_detail,"drawable", getPackageName());
        tononkira_image.setImageResource(srId);
        //set lohateny detail
        lohateny_detail_view.setText(lohateny_detail);
        //resource image
        //showMessage("test",lohateny_detail);
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}