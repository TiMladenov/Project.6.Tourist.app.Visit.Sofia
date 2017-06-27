/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DisplayFragment extends FragmentPagerAdapter {

    private Context context;

    public DisplayFragment(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
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
                return context.getString(R.string.fragment_tourism);
            case 1:
                return context.getString(R.string.fragment_cultural);
            case 2:
                return context.getString(R.string.fragment_sight);
            default:
                return null;
        }
    }
}
