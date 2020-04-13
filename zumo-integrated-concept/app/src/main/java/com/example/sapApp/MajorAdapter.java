package com.example.sapApp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MajorAdapter extends ArrayAdapter<MajorItem> {

    MajorFragment mMajorFragment;
    Context mContext;
    int mLayoutResourceId;


    public MajorAdapter(Context context, int layoutResourceId, MajorFragment majorFragment) {
        super(context, layoutResourceId);
        mContext = context;
        mLayoutResourceId = layoutResourceId;
        mMajorFragment = majorFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final MajorItem currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView majorName =  row.findViewById(R.id.majorNameBox);
        majorName.setText(currentItem.getMajorName());
        return row;
    }
}


