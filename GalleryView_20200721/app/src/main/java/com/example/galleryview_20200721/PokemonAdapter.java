package com.example.galleryview_20200721;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private Gallery gallery;
    public ArrayList<Pokemon> pokeList;

    public PokemonAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pokeList.size();
    }

    @Override
    public Object getItem(int i) {
        return pokeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView=layoutInflater.inflate(R.layout.pokemon_partition,null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);

        Pokemon pokemon = pokeList.get(i);
        imageView.setImageResource(pokemon.getImage());
        return convertView;
    }
}
