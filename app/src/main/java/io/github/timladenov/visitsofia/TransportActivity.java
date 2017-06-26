package io.github.timladenov.visitsofia;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TransportActivity extends AppCompatActivity {

    private ArrayList<DisplayInfo> mInfo;
    private String[] mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_transport);

        mInfo = new ArrayList<DisplayInfo>();

        final Spinner spinner = (Spinner) findViewById(R.id.transportSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transport_options, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String option = spinner.getSelectedItem().toString();
                mResources = getResources().getStringArray(R.array.transport_options);
                DataHolder.getInstace().setString(getResources().getString(R.string.text_list_view));
                if(option.equals(mResources[1])) {
                    getStringResources(getResources().getStringArray(R.array.air_companies));
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    DataHolder.getInstace().setArray(mInfo);
                    startActivity(intent);
                    finish();
                } else if(option.equals(mResources[2])) {
                    getStringResources(getResources().getStringArray(R.array.land_travel_companies));
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    DataHolder.getInstace().setArray(mInfo);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.select_option), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getStringResources(String[] mResources) {
        if(mResources != null) {
            for(int i = 1; i < mResources.length; i++) {
                int j = i;
                mInfo.add(new DisplayInfo(mResources[--j], mResources[i], R.mipmap.ic_launcher));
                i++;
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.empty_string), Toast.LENGTH_SHORT).show();
        }
    }
}
