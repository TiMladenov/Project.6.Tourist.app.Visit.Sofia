/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NightLifeActivity extends AppCompatActivity {

    /**
     * Check {@link HotelActivity} class for explanation on the code and variables.
     */

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;
    private String[] mMusicStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_list);

        mInfo = new ArrayList<DisplayInfo>();
        mResources = getResources().getStringArray(R.array.club_array);
        mMusicStyle = getResources().getStringArray(R.array.club_style);
        getStringResources(mResources);

        DisplayAdapter adapter = new DisplayAdapter(this, mInfo);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        // When the user taps on any of the list items, information about the style of the club will be displayed

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.club_music_style) + mMusicStyle[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getStringResources(String[] mResources) {
        if (mResources != null) {
            for (int i = 1; i < mResources.length; i++) {
                int j = i;
                mInfo.add(new DisplayInfo(mResources[--j], mResources[i], getResources().getString(R.string.text_list_view_3), R.mipmap.ic_launcher, R.color.list_club));
                i++;
            }
            String checkWord = getResources().getString(R.string.text_list_view);
            DataHolder.getInstace().setString(checkWord);
        } else {
            Toast.makeText(this, getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }
}
