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

/*
    This is the School Adapter Class which is called for setting the card-view for the school item.
    This fills up the list view with all of the school that it receives.
        -Alice Blair April 28, 2020
 */

public class schoolAdapter extends ArrayAdapter<School> {

    schoolFragment schoolFragment;
    Context mContext;
    int mLayoutResourceId;

    //AB: Simple Constructor to initialize everything.
    public schoolAdapter(Context context, int layoutResourceId, schoolFragment TDA) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
        schoolFragment = TDA;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //AB: Set Up the View and find what position you are currently at
        View row = convertView;
        final School currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        //AB: This sets up the card-view. It sets the name
        row.setTag(currentItem);
        final TextView schoolName = row.findViewById(R.id.checkToDoItem);

        //AB: Sets Up the on click listener for it which loads an HTML frag
        schoolName.setText(currentItem.getSchoolName());
        schoolName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                htmlViewerFragment nextFrag= new htmlViewerFragment(currentItem.getPageURL());
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "HTML Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return row;
    }


}