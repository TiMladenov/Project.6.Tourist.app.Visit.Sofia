package io.github.timladenov.visitsofia;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;
    private String[] mResourcesStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_list);

        mInfo = new ArrayList<DisplayInfo>();
        mResources = getResources().getStringArray(R.array.hotel_array);
        mResourcesStars = getResources().getStringArray(R.array.hotel_stars);
        getStringResources(mResources);

        DisplayAdapter adapter = new DisplayAdapter(this, mInfo);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mResourcesStars[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getStringResources(String[] mResources) {
        if (mResources != null) {
            for (int i = 1; i < mResources.length; i++) {
                int j = i;
                mInfo.add(new DisplayInfo(mResources[--j], mResources[i], getResources().getString(R.string.text_list_view_2)));
                i++;
            }
            String checkWord = getResources().getString(R.string.text_list_view);
            DataHolder.getInstace().setString(checkWord);
        } else {
            Toast.makeText(this, getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }
}
