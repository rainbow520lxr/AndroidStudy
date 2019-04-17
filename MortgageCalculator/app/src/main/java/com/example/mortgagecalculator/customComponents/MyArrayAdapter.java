package com.example.mortgagecalculator.customComponents;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MyArrayAdapter<T> extends ArrayAdapter{


    private int resource;
    private LayoutInflater inflater;
    private int mFieldId = 0;
    private Context mContext;

    public MyArrayAdapter(Context context, int resource) {
        super(context, resource);

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        final View view;
        final TextView text;

        if (convertView == null) {
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        try {
            if (mFieldId == 0) {
                //  If no custom field is assigned, assume the whole resource is a TextView
                text = (TextView) view;
            } else {
                //  Otherwise, find the TextView field within the layout
                text = view.findViewById(mFieldId);

                if (text == null) {
                    throw new RuntimeException("Failed to find view with ID "
                            + mContext.getResources().getResourceName(mFieldId)
                            + " in item layout");
                }
            }
        } catch (ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        }

        final T item = (T) getItem(position);
        if (item instanceof CharSequence) {
            text.setText((CharSequence) item);
        } else {
            text.setText(item.toString());
        }
        text.setTextSize(16);
        return view;
    }

}
