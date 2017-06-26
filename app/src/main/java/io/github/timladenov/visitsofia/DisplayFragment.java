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
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
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
            default:
                return null;
        }
    }
}
