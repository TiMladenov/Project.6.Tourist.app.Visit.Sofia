package io.github.timladenov.visitsofia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightSeeingFragment extends Fragment {

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;
    private View rootView;
    private DisplayAdapter adapter;
    private ListView list;

    public SightSeeingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_list, container, false);

        mInfo = new ArrayList<DisplayInfo>();
        mResources = getResources().getStringArray(R.array.sightseeing_location);
        getStringResources(mResources);

        adapter = new DisplayAdapter(getActivity(), mInfo);
        list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);

        return rootView;
    }

    private void getStringResources(String[] mResources) {
        if (mResources != null) {
            for (int i = 1; i < mResources.length; i++) {
                int j = i;
                mInfo.add(new DisplayInfo(mResources[--j], mResources[i], getResources().getString(R.string.text_list_view_5), R.mipmap.ic_launcher, R.color.list_hotel));
                i++;
            }
            DataHolder.getInstace().setString(getResources().getString(R.string.text_list_view));
            DataHolder.getInstace().setString_2(getResources().getString(R.string.rating));
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        DataHolder.getInstace().setString_2(null);
        rootView = null;
        mInfo = null;
        mResources = null;
        adapter = null;
        list = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        DataHolder.getInstace().setString_2(null);
        rootView = null;
        mInfo = null;
        mResources = null;
        adapter = null;
        list = null;
    }

}
