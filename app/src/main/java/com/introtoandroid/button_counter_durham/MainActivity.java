package com.introtoandroid.button_counter_durham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.introtoandroid.button_counter_durham.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

//declare buttons and text that will be used in view
    Button countBut;
    Button clearBut;
    TextView count;
    Button decrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        //Log.d("1", "In create 1");

        //initialize buttons and text with their ids in view
        countBut = (Button) findViewById(R.id.countButton);
        clearBut = (Button) findViewById(R.id.clearButton);
        count = (TextView) findViewById(R.id.countText);
        decrease = (Button) findViewById(R.id.decrease);

        //Log.d("1", "In create 2");
        //Log.d("1", "In create 3");

        //click listener for count button
        //this button increased the count by 1
        countBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("2", "inside click listener for count");
                //initialize a local temporary variable to grab what is currently in the textview
                //what is currently in count is a char so convert to string adn then to int
                int temp = Integer.parseInt(count.getText().toString().trim());
                //Log.d("2", "inside" + count.getText().toString());
                temp++;
                //set the text to the value plus one but convert back to string first
                count.setText((Integer.toString(temp)));
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("2", "inside click listener for count");
                //initialize a local temporary variable to grab what is currently in the textview
                //what is currently in count is a char so convert to string adn then to int
                int temp = Integer.parseInt(count.getText().toString().trim());
                //Log.d("2", "inside" + count.getText().toString());
                temp--;
                //set the text to the value plus one but convert back to string first
                count.setText((Integer.toString(temp)));
            }
        });


        //click listener for clear button
        //this button resets the text view to 0
        clearBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //grabs string from resources to set count
                count.setText(getResources().getString(R.string.zero));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String value = count.getText().toString();
        outState.putString("key", value);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("key");
        count.setText(value);
    }
}
