package com.example.sapApp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/*
    This is the Major Adapter Class which is called for setting the card-view for the major item.
    This fills up the list view with all of the majors that it receives.
        -Alice Blair April 28, 2020
 */

public class majorAdapter extends ArrayAdapter<Major> {

    majorFragment mMajorFragment;
    Context mContext;
    int mLayoutResourceId;


    //AB: Simple Constructor to initialize everything.
    public majorAdapter(Context context, int layoutResourceId, majorFragment majorFragment) {
        super(context, layoutResourceId);
        mContext = context;
        mLayoutResourceId = layoutResourceId;
        mMajorFragment = majorFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //AB: Set Up the View and find what position you are currently at
        View row = convertView;
        final Major currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        //AB: This sets up the card-view. It sets the name, and all of the checkboxes.
        row.setTag(currentItem);
        final TextView majorName =  row.findViewById(R.id.majorNameBox);
        final CheckBox bachelorsCheck, masters, doctorate, other;
        bachelorsCheck = row.findViewById(R.id.bachelorsCheck);
        masters = row.findViewById(R.id.mastersCheck);
        doctorate = row.findViewById(R.id.doctorateCheck);
        other = row.findViewById(R.id.otherCheck);

        //AB: If the major item says that it is true it sets the checkbox to checked.
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


