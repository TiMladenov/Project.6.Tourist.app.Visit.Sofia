package io.github.timladenov.visitsofia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private ArrayList<DisplayInfo> mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mInfo = new ArrayList<DisplayInfo>();
        mInfo = DataHolder.getInstace().getData();

        DisplayAdapter adapter_2 = new DisplayAdapter(this, mInfo);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter_2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mInfo.clear();
        finish();
    }
}
