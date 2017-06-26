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

        if(myWord.canHideSeparator()) {
            View separator = listItemsView.findViewById(R.id.separator);
            separator.setVisibility(View.GONE);

            ActionBar actionBar = myWord.getmActionbar();
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#81C784")));
        }

        if(myWord.hasImage()) {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(myWord.getmImageLocation());
            image.setBackgroundColor(Color.WHITE);
        }

        if (!(myWord.getmCompany().equals(DataHolder.getInstace().getmString()))) {
            TextView txt = (TextView) listItemsView.findViewById(R.id.company_name);
            txt.setText(myWord.getmCompany());
        }

        if (!(myWord.getmCompany().equals(DataHolder.getInstace().getmString_2())) && (DataHolder.getInstace().getmString_2() != null)) {
            TextView txt = (TextView) listItemsView.findViewById(R.id.company_phone);
            txt.setText(DataHolder.getInstace().getmString_2());
        }

        RelativeLayout relLayout = (RelativeLayout) listItemsView.findViewById(R.id.text_container_list);
        relLayout.setBackgroundResource(myWord.getmColorBack());

        TextView mCompanyName = (TextView) listItemsView.findViewById(R.id.text1);
        mCompanyName.setText(myWord.getmCompanyName());

        TextView mCompanyPhone = (TextView) listItemsView.findViewById(R.id.text2);
        mCompanyPhone.setText(myWord.getmTelefonNum());

        return listItemsView;
    }
}
