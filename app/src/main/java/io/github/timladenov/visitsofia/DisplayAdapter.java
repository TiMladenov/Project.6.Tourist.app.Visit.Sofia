/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayAdapter extends ArrayAdapter<DisplayInfo> {

    DisplayAdapter(Activity context, ArrayList<DisplayInfo> listItems) {
        super(context, 0, listItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemsView = convertView;
        if (listItemsView == null) {
            listItemsView = LayoutInflater.from(getContext()).inflate(R.layout.twin_layout, parent, false);
        }

        DisplayInfo myWord = getItem(position);

        // Hides imageview if image is missing
        ImageView image = (ImageView) listItemsView.findViewById(R.id.image_2);
        image.setVisibility(View.GONE);


        // checks if can hide separator in list item
        if(myWord.canHideSeparator()) {
            View separator = listItemsView.findViewById(R.id.separator);
            separator.setVisibility(View.GONE);

            ActionBar actionBar = myWord.getmActionbar();
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#81C784")));
        }

        // restores imageview if image resource is available
        if(myWord.hasImage()) {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(myWord.getmImageLocation());
            image.setBackgroundColor(Color.WHITE);
        }

        // used to programmatically change the "Company" textview text to something else, when provided
        if (!(myWord.getmCompany().equals(DataHolder.getInstace().getmString()))) {
            TextView txt = (TextView) listItemsView.findViewById(R.id.company_name);
            txt.setText(myWord.getmCompany());
        }

        // used to programmatically change "Phone" textview text to something else, when provided
        if (!(myWord.getmCompany().equals(DataHolder.getInstace().getmString_2())) && (DataHolder.getInstace().getmString_2() != null)) {
            TextView txt = (TextView) listItemsView.findViewById(R.id.company_phone);
            txt.setText(DataHolder.getInstace().getmString_2());
        }

        // initiates list item and background of layout

        RelativeLayout relLayout = (RelativeLayout) listItemsView.findViewById(R.id.text_container_list);
        relLayout.setBackgroundResource(myWord.getmColorBack());

        TextView mCompanyName = (TextView) listItemsView.findViewById(R.id.text1);
        mCompanyName.setText(myWord.getmCompanyName());

        TextView mCompanyPhone = (TextView) listItemsView.findViewById(R.id.text2);
        mCompanyPhone.setText(myWord.getmTelefonNum());

        return listItemsView;
    }
}
