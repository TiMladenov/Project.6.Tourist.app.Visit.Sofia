package io.github.timladenov.visitsofia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private ArrayList<DisplayInfo> mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mInfo = new ArrayList<DisplayInfo>();
        mInfo = DataHolder.getInstace().getData();

        DisplayAdapter adapter_2 = new DisplayAdapter(this, mInfo);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter_2);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "It works", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mInfo.clear();
        finish();
    }
}
