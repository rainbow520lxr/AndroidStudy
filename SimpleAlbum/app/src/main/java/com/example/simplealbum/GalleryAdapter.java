package com.example.simplealbum;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.List;


public class GalleryAdapter extends BaseAdapter {

    private Context context;
    private int[] imgs;

    public GalleryAdapter(Context context, int[] imgs){
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int id) {
        return imgs[id];
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int id, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(imgs[id%imgs.length]);
        iv.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return iv;
    }
}
