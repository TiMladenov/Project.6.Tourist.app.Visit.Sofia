/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Check {@link HotelActivity} class for explanation on the code and variables.
 */

public class CulturalFragment extends Fragment {

    public CulturalFragment() {
        // Required empty public constructor
    }

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;
    private View rootView;
    private DisplayAdapter adapter;
    private ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_list, container, false);

        mInfo = new ArrayList<DisplayInfo>();
        mResources = getResources().getStringArray(R.array.museum_location);
        getStringResources(mResources);

        adapter = new DisplayAdapter(getActivity(), mInfo);
        list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);

        return rootView;
    }

    private void getStringResources(String[] mResources) {
        if (mResources != null) {
            for (int i = 0; i < mResources.length; i++) {
                Random random = new Random();
                int x = Math.abs(random.nextInt(400) - (i * 4));
                String visit = getResources().getString(R.string.visited);
                String times = getResources().getString(R.string.visited_times);
                mInfo.add(new DisplayInfo(mResources[i], visit + x + times , getResources().getString(R.string.text_list_view_5), R.mipmap.ic_launcher, R.color.list_resto));
            }
            DataHolder.getInstace().setString(getResources().getString(R.string.text_list_view));
            DataHolder.getInstace().setString_2(getResources().getString(R.string.visits));
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        releaseResources();
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseResources();
    }

    private void releaseResources() {
        DataHolder.getInstace().setString_2(null);
        rootView = null;
        mInfo = null;
        mResources = null;
        adapter = null;
        list = null;
    }
}
