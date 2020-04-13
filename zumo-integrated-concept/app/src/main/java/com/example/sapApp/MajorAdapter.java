package com.example.sapApp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MajorAdapter extends ArrayAdapter<Major> {

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

        final Major currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView majorName =  row.findViewById(R.id.majorNameBox);
        final CheckBox bachelorsCheck, masters, doctorate, other;
        bachelorsCheck = row.findViewById(R.id.bachelorsCheck);
        masters = row.findViewById(R.id.mastersCheck);
        doctorate = row.findViewById(R.id.doctorateCheck);
        other = row.findViewById(R.id.otherCheck);

        majorName.setText(currentItem.getMajorName());
        if(currentItem.getmBachelors())
        {
            bachelorsCheck.setChecked(true);
        }
        if(currentItem.getmMasters())
        {
            masters.setChecked(true);
        }
        if(currentItem.getmDoctorate())
        {
            doctorate.setChecked(true);
        }
        if(currentItem.getmOther())
        {
            other.setChecked(true);
        }


        return row;
    }
}


