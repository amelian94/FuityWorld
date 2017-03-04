package com.neonidapps.fuityworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neonidapps.fuityworld.R;
import com.neonidapps.fuityworld.models.Fruta;

import java.util.List;

/**
 * Created by Neonidas on 02/03/2017.
 */

public class FruitsAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruta> frutas;

    public FruitsAdapter(Context context, int layout, List<Fruta> frutas) {

        this.context = context;
        this.layout = layout;
        this.frutas = frutas;


    }

    @Override
    public int getCount() {
        return this.frutas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.frutas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(this.layout, null);

        String currentName = this.frutas.get(position).getName();
        String currentOrigin = this.frutas.get(position).getOrigin();
        int currentIcon = this.frutas.get(position).getRefIcon();

        TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
        TextView textViewOrigin = (TextView) v.findViewById(R.id.textViewOrigin);
        ImageView imageViewIcon = (ImageView) v.findViewById(R.id.imageViewFruit);

        textViewName.setText(currentName);
        textViewOrigin.setText(currentOrigin);
        imageViewIcon.setBackground(v.getResources().getDrawable(currentIcon));


        return v;

    }
}
