package io.github.timladenov.visitsofia;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tmladenov on 25.06.17.
 */

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

        ImageView image = (ImageView) listItemsView.findViewById(R.id.image_2);
        image.setVisibility(View.GONE);
        if(myWord.hasImage()) {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(myWord.getmImageLocation());
            image.setBackgroundColor(Color.WHITE);
        }

        if (!(myWord.getmCompany().equals(DataHolder.getInstace().getmString()))) {
            TextView txt = (TextView) listItemsView.findViewById(R.id.company_name);
            txt.setText(myWord.getmCompany());
        }

        TextView mCompanyName = (TextView) listItemsView.findViewById(R.id.text1);
        mCompanyName.setText(myWord.getmCompanyName());

        TextView mCompanyPhone = (TextView) listItemsView.findViewById(R.id.text2);
        mCompanyPhone.setText(myWord.getmTelefonNum());

        return listItemsView;
    }
}
