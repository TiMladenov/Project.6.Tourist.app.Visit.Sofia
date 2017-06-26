/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * @param viewPager     is the view, used to store the views
         * @param adapter       gets the information about the fragment count and structure
         * @param tableLayout   arranges the tabs for the viewPager pages
         */

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_things_to_do);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        DisplayFragment adapter = new DisplayFragment(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tableLayout = (TabLayout) findViewById(R.id.tablayout);
        tableLayout.setupWithViewPager(viewPager);
    }
}
