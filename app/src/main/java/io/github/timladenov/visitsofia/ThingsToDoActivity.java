package io.github.timladenov.visitsofia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
