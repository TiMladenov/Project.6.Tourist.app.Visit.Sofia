package io.github.timladenov.visitsofia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTransport;
    private TextView mHotels;
    private TextView mRestaurants;
    private TextView mNightLife;
    private TextView mThingsToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mTransport = (TextView) findViewById(R.id.transport);
        mHotels = (TextView) findViewById(R.id.hotels);
        mRestaurants = (TextView) findViewById(R.id.restaurants);
        mNightLife = (TextView) findViewById(R.id.nightlife);
        mThingsToDo = (TextView) findViewById(R.id.place_to_visit);

        mTransport.setOnClickListener(this);
        mHotels.setOnClickListener(this);
        mRestaurants.setOnClickListener(this);
        mNightLife.setOnClickListener(this);
        mThingsToDo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transport:
                Intent toTransport = new Intent(this, TransportActivity.class);
                startActivity(toTransport);
                break;
            case R.id.hotels:
                Intent toHotels = new Intent(this, HotelActivity.class);
                startActivity(toHotels);
                break;
            case R.id.restaurants:
                Intent toResto = new Intent(this, RestaurantActivity.class);
                startActivity(toResto);
                break;
            case R.id.nightlife:
                Intent toNl = new Intent(this, NightLifeActivity.class);
                startActivity(toNl);
                break;
            case R.id.place_to_visit:
                Intent toThings = new Intent(this, ThingsToDoActivity.class);
                startActivity(toThings);
                break;
        }
    }
}
