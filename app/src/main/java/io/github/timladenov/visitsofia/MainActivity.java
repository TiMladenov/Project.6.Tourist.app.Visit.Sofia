/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * @param mTransport    is used to start Transport activity
     * @param mHotels       is used to start Hotels activity
     * @param mRestaurants  is used to start Restaurants activity
     * @param mNightLife    is used to start Nightlife activity
     * @param mThingsToDo   is used to start ThingsToDo activity
     *
     * The activities are based mostly on the same code template.
     * To see explanation go to {@link HotelActivity}, I will provide notes when
     * there are exceptions.
     */

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

    //Listens to user's button clicks, performs the corresponding action

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
