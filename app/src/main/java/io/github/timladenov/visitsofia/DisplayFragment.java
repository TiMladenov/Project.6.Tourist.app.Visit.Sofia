package io.github.timladenov.visitsofia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tmladenov on 26.06.17.
 */

public class DisplayFragment extends FragmentPagerAdapter {
    public DisplayFragment(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TourismFragment();
            case 1:
                return new CulturalFragment();
            case 2:
                return new SightSeeingFragment();
            case 3:
                return new PracticeBulgarianFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tourism";
            case 1:
                return "Culture";
            case 2:
                return "Sights";
            case 3:
                return "Assist";

//            case 0:
//                return Resources.getSystem().getString(R.string.fragment_tourism);
//            case 1:
//                return Resources.getSystem().getString(R.string.fragment_cultural);
//            case 2:
//                return Resources.getSystem().getString(R.string.fragment_sight);
//            case 3:
//                return Resources.getSystem().getString(R.string.fragment_phrases);
            default:
                return null;
        }
    }
}
