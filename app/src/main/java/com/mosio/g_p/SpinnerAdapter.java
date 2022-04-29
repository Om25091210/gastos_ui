package com.mosio.g_p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SpinnerAdapter extends ArrayAdapter<String> {
    private final String[] objects;
    String firstElement;
    boolean isFirstTime;

    public SpinnerAdapter(Context context, int textViewResourceId, String[] objects,String defaultText) {
        super(context, textViewResourceId, objects);
        this.objects=objects;
        this.isFirstTime = true;
        setDefaultText(defaultText);
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        if(isFirstTime) {
            objects[0] = firstElement;
            isFirstTime = false;
        }
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        notifyDataSetChanged();
        return getCustomView(position, convertView, parent);
    }

    public void setDefaultText(String defaultText) {
        this.firstElement = objects[0];
        objects[0] = defaultText;
    }
    private View getCustomView(final int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_spinner, parent, false);
        final TextView label=row.findViewById(R.id.tv_spinnervalue);
        label.setText(objects[position]);
        return row;
    }
}