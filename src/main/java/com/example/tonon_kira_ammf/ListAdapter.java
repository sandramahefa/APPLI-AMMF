package com.example.tonon_kira_ammf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Hira> listHira;

    public ListAdapter(Context context, List<Hira> listHira){
        this.context = context;
        this.listHira = listHira;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listHira.size();
    }

    @Override
    public Hira getItem(int position) {
        return listHira.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_layout, null);

        Hira currentHIra = getItem(i);
        String itemLohateny = currentHIra.getLohateny();
        String itemSokajy = currentHIra.getSokajy();
        String itemAnarana = currentHIra.getAnarana();

        //get item lohateny

        TextView itemTitleLohateny = view.findViewById(R.id.item_lohateny);
        itemTitleLohateny.setText(itemLohateny);


        //get item sokajy

        TextView itemTitleSokajy = view.findViewById(R.id.item_sokajy);
        itemTitleSokajy.setText(itemSokajy);
        return view;
        }
}
