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

public class HotelActivity extends AppCompatActivity {

    /**
     * @param mInfo             holds the DisplayInfo objects, which are used to store information to be displayed in the views in @param list
     * @param mResources        used to get the string-array resources, then they are transferred to mInfo, entered as DisplayInfo objects
     * @param mResourcesStars   additional resources from string-array, different for each view. This one contains array with star ratings for the hotels,
     *                          which are displayed ones the user taps on the hotel
     * @param adapter           feeds the date from @param mInfo into @param list and inflates the custom layout
     * @param list              displays the date from @adapter
     *
     * @param DataHolder        is a Singleton class, which I sometimes used to transfer objects between activities
     */

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;
    private String[] mResourcesStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_list);

        mInfo = new ArrayList<DisplayInfo>();
        mResources = getResources().getStringArray(R.array.hotel_array);
        mResourcesStars = getResources().getStringArray(R.array.hotel_stars);
        getStringResources(mResources);

        DisplayAdapter adapter = new DisplayAdapter(this, mInfo);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        // Gets the stars for each hotel, if the user tabs on its name

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mResourcesStars[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Used to transfer the string-array data from resources into mInfo as DisplaInfo objects

    private void getStringResources(String[] mResources) {
        if (mResources != null) {
            for (int i = 1; i < mResources.length; i++) {
                int j = i;
                mInfo.add(new DisplayInfo(mResources[--j], mResources[i], getResources().getString(R.string.text_list_view_2), R.mipmap.ic_launcher, R.color.list_hotel, true, getSupportActionBar()));
                i++;
            }
            // Sets the text view above hotel name to Company, used to check and set it to Hotel, hence Hotel view
            String checkWord = getResources().getString(R.string.text_list_view);
            DataHolder.getInstace().setString(checkWord);
        } else {
            Toast.makeText(this, getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }
}
