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

        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(this.context).inflate(this.layout, null);

            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.origin = (TextView) convertView.findViewById(R.id.textViewOrigin);
            holder.refIcon = (ImageView) convertView.findViewById(R.id.imageViewFruit);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fruta currentFruit = frutas.get(position);

        holder.name.setText(currentFruit.getName());
        holder.origin.setText(currentFruit.getOrigin());
        holder.refIcon.setImageResource(currentFruit.getRefIcon());


        return convertView;

    }

    static class ViewHolder {

        private TextView name;
        private TextView origin;
        private ImageView refIcon;
    }

}
