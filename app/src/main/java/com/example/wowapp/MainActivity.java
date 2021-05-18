package com.example.wowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    Button numBtn;
    TextView numTxt;

    ListView listView;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WindowsMobile","Blackberry","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X","Windows7","Max OS X","Windows7","Max OS X"};

    ArrayList<TimeDataModel> timeDataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numBtn = (Button) findViewById(R.id.numBtn);
        numTxt = (TextView) findViewById(R.id.numTxt);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mobileArray);
        listView.setAdapter(adapter);
        numBtn.setOnClickListener(getClickListener());

        timeDataModels= new ArrayList<>();
        timeDataModels.add(new TimeDataModel("Pakistan","\uD83C\uDDF5\uD83C\uDDF0", 0,false));
        timeDataModels.add(new TimeDataModel("India","\uD83C\uDDEE\uD83C\uDDF3", 0,false));
        timeDataModels.add(new TimeDataModel("UK","🇮🇳\uD83C\uDDEC\uD83C\uDDE7", 0,false));
        timeDataModels.add(new TimeDataModel("USA","🇮🇳\uD83C\uDDFA\uD83C\uDDF8", 0,false));
        timeDataModels.add(new TimeDataModel("Palestine","🇮🇳\uD83C\uDDF5\uD83C\uDDF8", 0,false));
        timeDataModels.add(new TimeDataModel("Iran","🇮\uD83C\uDDEE\uD83C\uDDF7🇳", 0,false));
        timeDataModels.add(new TimeDataModel("Canada","🇮🇳\uD83C\uDDE8\uD83C\uDDE6", 0,false));
        timeDataModels.add(new TimeDataModel("China","🇮🇳\uD83C\uDDE8\uD83C\uDDF3", 0,false));
        timeDataModels.add(new TimeDataModel("Saudi","🇮🇳\uD83C\uDDF8\uD83C\uDDE6", 0,false));
        Log.i(u.TAG, "hi " + timeDataModels.get(0).getCountrySymbol());

        // update view
        numTxt.setText(timeDataModels.get(i%timeDataModels.size()).getCountrySymbol() + "");

    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        try{
            savedInstanceState.putSerializable("iValue",i);
        }
        catch(Exception ex){
            Log.i(u.TAG,"ex i onSaveInstanceState: " + ex.getMessage());
        }

    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        try{
            Log.i(u.TAG,"i onRestoreInstanceState: " + i);

            // update state
            i = (int) savedInstanceState.getSerializable("iValue");

            // update view
            numTxt.setText(timeDataModels.get(i%timeDataModels.size()).getCountrySymbol() + "");
        }
        catch(Exception ex){
            Log.i(u.TAG,"ex i onRestoreInstanceState: " + ex.getMessage());
        }
    }

    private View.OnClickListener getClickListener(){
        return (View.OnClickListener) v -> {

            // update state
            i++;

            // update view
            numTxt.setText(timeDataModels.get(i%timeDataModels.size()).getCountrySymbol() + "");
        };
    }
}