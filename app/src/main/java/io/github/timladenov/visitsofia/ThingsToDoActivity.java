package io.github.timladenov.visitsofia;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_things_to_do);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        DisplayFragment adapter = new DisplayFragment(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablayout);
        tableLayout.setupWithViewPager(viewPager);
    }
}
